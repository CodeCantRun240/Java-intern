package backend.controller;
import backend.dto.EntityDTO;
import backend.model.CreateUser;
import backend.repository.UserRepository;
import backend.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import backend.mapper.GetUserMapper;



@RestController
public class UserController {

   
    private GetUserMapper userMapper;

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {

        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/create-users")
    public EntityDTO createUser(@Valid @RequestBody EntityDTO entityDTO) {
        CreateUser createUser = userMapper.toEntity(entityDTO);
        createUser.setCreatedAt(ZonedDateTime.now());
        createUser.setUpdatedAt(ZonedDateTime.now());
        createUser.setScheduleNo(0);

        CreateUser savedUser = userRepository.save(createUser);
        return userMapper.toDTO(savedUser);
    }

    @GetMapping("/all-users")
    public List<EntityDTO> getUsers() {
        List<CreateUser> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    @PatchMapping("/update-users")
    public ResponseEntity<CreateUser> updateUser(@RequestHeader("userId") Long userId,
                                                 @RequestBody CreateUser updateUser) {
        CreateUser createUser = userService.updateUser(userId, updateUser);
        return ResponseEntity.ok(createUser);
    }

    @DeleteMapping("/delete-users")
    public ResponseEntity<Void> deleteUser(@RequestHeader("userId") Long userId) {
        if (!userRepository.existsById(userId)) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}




