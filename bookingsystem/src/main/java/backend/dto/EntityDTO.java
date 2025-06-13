package backend.dto;

import backend.validation.RepetitiveValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityDTO {
    private Long userId;

    @NotBlank(message = "userName must not be empty")
    private String userName;

    @RepetitiveValidator
    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "position must not be empty")
    private String position;


    private Integer scheduleNo;

    @NotNull(message = "phoneNumber must not be empty")
    private Long phoneNumber;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @JsonIgnore
    private Boolean deleted;

    public Long getUserId() { return userId; }

    public void setUserId(Long user_id) { this.userId = user_id; }

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


}
