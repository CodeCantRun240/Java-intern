package backend.controller;
import backend.dto.EntityDTO;
import backend.model.CreateUser;
import backend.repository.UserRepository;

import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/create-user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public CreateUser createUser(@RequestBody EntityDTO entityDTO) {
        CreateUser createUser = new CreateUser();
        createUser.setUserName(entityDTO.getUserName());
        createUser.setPassword(entityDTO.getPassword());
        createUser.setEmail(entityDTO.getEmail());
        createUser.setPhoneNumber(entityDTO.getPhoneNumber());
        createUser.setPosition(entityDTO.getPosition());
        createUser.setCreatedAt(ZonedDateTime.now());
        createUser.setUpdatedAt(ZonedDateTime.now());
        createUser.setScheduleNo(0);
        CreateUser user = userRepository.save(createUser);

        return user;
    }
}