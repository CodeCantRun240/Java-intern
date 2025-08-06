package backend.controller;

import backend.Enums.TodoStatus;
import backend.dto.NoteDTO;
import backend.dto.NoteWithAlarmsDTO;
import backend.model.CreateNote;
import backend.model.CreateUser;
import backend.service.NoteWithAlarmsService;
import backend.service.GetNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private GetNoteService getNoteService;

    @Autowired
    private NoteWithAlarmsService noteWithAlarmService;

    private final NoteWithAlarmsService noteWithAlarmsService;

    @Autowired
    public NoteController(NoteWithAlarmsService noteWithAlarmsService) {
        this.noteWithAlarmsService = noteWithAlarmsService;
    }

    @PostMapping("/note_alarms")
    public ResponseEntity<String> createNote(@RequestBody NoteWithAlarmsDTO dto, @RequestHeader("user_id") Long userId) {

        noteWithAlarmsService.SetNoteAlarm(userId, dto );
        return ResponseEntity.ok("Note created successfully");
    }

    @GetMapping("/get_notes")
    public ResponseEntity<List<NoteDTO>> getNotesForUser(
            @RequestHeader("user_id") Long userId,
            @RequestParam("todo") TodoStatus todo){
        List<NoteDTO> notes = getNoteService.getNoteService(userId, todo);;
        return ResponseEntity.ok(notes);
    }

    @PatchMapping("/update-notes")
    public ResponseEntity<NoteDTO> updateNote(
            @RequestParam Long noteId,
            @RequestBody NoteDTO dto
    ) {
        NoteDTO updatedNote = noteWithAlarmService.updateNote(noteId, dto);
        return ResponseEntity.ok(updatedNote);
    }
}
