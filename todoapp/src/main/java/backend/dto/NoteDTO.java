package backend.dto;


import java.util.List;

public class NoteDTO {
    private long NoteId;

    private String noteContent;

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    private String todo;

    private List<AlarmDTO> alarms;

    public List<AlarmDTO> getAlarms() {
        return alarms;
    }

    public long getNoteId() {
        return NoteId;
    }

    public void setNoteId(long noteId) {
        NoteId = noteId;
    }

    public void setAlarms(List<AlarmDTO> alarms) {
        this.alarms = alarms;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
