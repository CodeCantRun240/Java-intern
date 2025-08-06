package backend.dto;

import java.time.LocalTime;

public class AlarmDTO {

    private LocalTime alarmTime;
    private Long alarmId;     // manually assigned
    private Long noteId;

    public Long getAlarmId() { return alarmId; }
    public void setAlarmId(Long alarmId) { this.alarmId = alarmId; }

    public Long getNoteId() { return noteId; }
    public void setNoteId(Long noteId) { this.noteId = noteId; }

    public  LocalTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }


}
