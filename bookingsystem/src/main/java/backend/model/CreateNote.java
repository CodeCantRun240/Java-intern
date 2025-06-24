package backend.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "note_list")
public class CreateNote {
    private static final Logger log = LoggerFactory.getLogger(CreateNote.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "note_content")
    private String noteContent;


    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private CreateUser user;

    public CreateUser getUser() {
        return user;
    }

    public void setUser(CreateUser user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlarmEntity> alarms = new ArrayList<>();

    public List<AlarmEntity> getAlarm() {
        return alarms;
    }

    public void setAlarm(List<AlarmEntity> alarms) {
        this.alarms = alarms;
    }
}
