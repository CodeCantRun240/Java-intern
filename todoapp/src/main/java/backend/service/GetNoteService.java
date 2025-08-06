package backend.service;

import backend.Enums.TodoStatus;
import backend.dto.NoteDTO;
import backend.dto.AlarmDTO;
import backend.model.CreateNote;
import backend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
public class GetNoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    public GetNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Transactional(readOnly = true)
    public List<NoteDTO> getNoteService(Long userId, TodoStatus todo) {
        List<CreateNote> notes;
        if (todo != null) {
            notes = noteRepository.findByUserIdAndTodo(userId, todo);
        } else {
            notes = noteRepository.findByUserId(userId);
        }
        // Force lazy loading of alarms inside transaction
        for (CreateNote note : notes) {
            note.getAlarm().size(); // Triggers fetch for each note's alarms
        }



        return notes.stream().map(note -> {

            NoteDTO dto = new NoteDTO();
            dto.setNoteId(note.getNoteId());
            dto.setNoteContent(note.getNoteContent());
            dto.setTodo(note.getTodo());
            dto.setAlarms(
                    note.getAlarm().stream().map(al -> {
                        AlarmDTO a = new AlarmDTO();
                        a.setAlarmId(al.getAlarmId());
                        a.setAlarmTime(al.getAlarmTime());
                        return a;
                    }).toList()
            );
            return dto;
        }).toList();
    }
}