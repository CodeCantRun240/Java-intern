package backend.controller;

import backend.dto.NoteDTO;
import backend.model.CreateNote;
import backend.service.NoteWithAlarmsService;
import backend.service.GetNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note_alarms")
public class NoteController {
    @Autowired
    private GetNoteService noteService;

    private final NoteWithAlarmsService noteWithAlarmsService;

    public NoteController(NoteWithAlarmsService noteWithAlarmsService) {
        this.noteWithAlarmsService = noteWithAlarmsService;
    }

    @PostMapping
    public ResponseEntity<?> createNote(
            @RequestBody NoteDTO dto,
            @RequestHeader("user_id") Long userId) {

        CreateNote saved = noteWithAlarmsService.createNoteAlarms(dto, userId);
        return ResponseEntity.ok("Note created with ID: " + saved.getNoteId());
    }

    @GetMapping("/get_notes")
    public ResponseEntity<List<CreateNote>> getNotesForUser(
            @RequestParam("user_id") Long userId) {
        List<CreateNote> notes = noteService.getNotesWithAlarms(userId);
        return ResponseEntity.ok(notes);
    }
}
