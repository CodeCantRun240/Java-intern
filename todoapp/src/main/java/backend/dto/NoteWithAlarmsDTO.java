package backend.dto;

import java.util.List;

public class NoteWithAlarmsDTO {
    private Long noteId; // manually assigned
    private Long userId;
    private String noteContent;
    private List<AlarmDTO> alarms;

    public Long getNoteId() { return noteId; }
    public void setNoteId(Long noteId) { this.noteId = noteId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public List<AlarmDTO> getAlarms() {
        return alarms;
    }

    public void setAlarms(List<AlarmDTO> alarms) {
        this.alarms = alarms;
    }
}