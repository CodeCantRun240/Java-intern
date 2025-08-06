package backend.dto;

import backend.validation.RepetitiveValidator;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO {
    private Long userId;
    
    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;


    public Long getUserId() { return userId; }

    public void setUserId(Long user_id) { this.userId = user_id; }

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


}
