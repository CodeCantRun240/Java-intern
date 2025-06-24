package backend.service;

import backend.model.CreateNote;
import backend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetNoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Transactional(readOnly = true)
    public List<CreateNote> getNotesWithAlarms(Long userId) {
        List<CreateNote> notes = noteRepository.findByUserId(userId);

        // Ensures lazy alarms are loaded
        for (CreateNote note : notes) {
            note.getAlarm().size();
        }

        return notes;
    }
}