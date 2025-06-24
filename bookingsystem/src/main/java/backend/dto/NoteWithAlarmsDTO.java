package backend.dto;

import java.util.List;

public class NoteWithAlarmsDTO {
    private String noteContent;
    private List<AlarmDTO> alarms;

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