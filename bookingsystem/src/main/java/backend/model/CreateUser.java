package backend.model;
import backend.model.CreateNote;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "user_info")
public class CreateUser {
    private static final Logger log = LoggerFactory.getLogger(CreateUser.class);


    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "position")
    private String position;

    @Column(name = "schedule_no")
    private Integer scheduleNo;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    //@Column(name = "deleted")
   //    private Boolean deleted;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(Integer scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public Long getPhoneNumber() {
        log.debug("Got the phone number: " + phoneNumber);
        return phoneNumber;

    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    //public Boolean getDeleted() {
    //    return deleted;
   // }

   //public void setDeleted(Boolean deleted) {
    //    this.deleted = deleted;
   // }
   @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<CreateNote> notes;

    public List<CreateNote> getNotes() {
        return notes;
    }

    public void setNotes(List<CreateNote> notes) {
        this.notes = notes;
    }
}
