package backend.service;

import backend.dto.AlarmDTO;
import backend.dto.NoteDTO;
import backend.dto.NoteWithAlarmsDTO;
import backend.mapper.NoteMapper;
import backend.model.AlarmEntity;
import backend.model.CreateNote;

import backend.repository.AlarmRepository;
import backend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteWithAlarmsService {
    private NoteMapper noteMapper;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    public void NoteService(NoteRepository noteRepository, AlarmRepository alarmRepository, NoteMapper noteMapper) {

        this.noteRepository = noteRepository;
        this.alarmRepository = alarmRepository;
        this.noteMapper = noteMapper;
    }

    @Transactional
    public void SetNoteAlarm(Long userId, NoteWithAlarmsDTO dto) {
        CreateNote note = new CreateNote();

        note.setUserId(userId);
        note.setNoteContent(dto.getNoteContent());

        CreateNote savedNote = noteRepository.save(note);

        List<AlarmEntity> alarms = new ArrayList<>();
        for (AlarmDTO time : dto.getAlarms()) {
            AlarmEntity alarm = new AlarmEntity();
            alarm.setAlarmTime(time.getAlarmTime());
            alarm.setNote(savedNote); // set FK
            alarms.add(alarm);
        }
        alarmRepository.saveAll(alarms);

    }

    public NoteDTO updateNote(Long noteId, NoteDTO dto) {
        return noteRepository.findById(noteId).map(note ->{

        if (dto.getNoteContent() != null) {
            note.setNoteContent(dto.getNoteContent());
        }

        if (dto.getTodo() != null) {
            note.setTodo(dto.getTodo());
        }

        CreateNote saved = noteRepository.save(note);
            return noteMapper.toDTO(saved);

        }).orElseThrow(() -> new RuntimeException("Note not found"));

    }
}
