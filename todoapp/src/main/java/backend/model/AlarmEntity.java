package backend.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "alarm")
public class AlarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long alarmId;


    @Column(name = "alarm_time")
    private LocalTime alarmTime;


    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id", nullable = false)
    private CreateNote note;

    public CreateNote getNote() {
        return note;
    }

    public void setNote(CreateNote note) {
        this.note = note;
    }
}
