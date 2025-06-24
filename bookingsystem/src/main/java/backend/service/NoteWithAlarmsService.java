package backend.service;

import backend.dto.AlarmDTO;
import backend.dto.NoteDTO;
import backend.dto.NoteWithAlarmsDTO;
import backend.model.AlarmEntity;
import backend.model.CreateNote;

import backend.repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteWithAlarmsService {

    @Autowired
    private NoteRepository noteRepository;

    public NoteWithAlarmsService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Transactional
    public CreateNote createNoteAlarms(NoteDTO dto, Long userId) {
        CreateNote note = new CreateNote();
        note.setUserId(userId);
        note.setNoteContent(dto.getNoteContent());

        List<AlarmEntity> alarmEntities = new ArrayList<>();
        if (dto.getAlarms() != null) {
            for (AlarmDTO dtoAlarm : dto.getAlarms()) {
                AlarmEntity alarmEntity = new AlarmEntity();
                alarmEntity.setAlarmTime(dtoAlarm.getAlarmTime());
                alarmEntity.setNote(note);
                alarmEntities.add(alarmEntity);
            }
        }

        note.setAlarm(alarmEntities);
        return noteRepository.save(note);
    }
}
