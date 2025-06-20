package backend.controller;
import backend.dto.EntityDTO;
import backend.model.CreateUser;
import backend.repository.UserRepository;
import backend.repository.UserPaging;
import backend.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import backend.mapper.GetUserMapper;




@RestController
public class UserController {

    @Autowired
    private GetUserMapper userMapper;

    private final UserRepository userRepository;
    private final UserService userService;
    private UserPaging userPaging;


    public UserController(UserRepository userRepository, UserService userService, UserPaging userPaging) {

        this.userRepository = userRepository;
        this.userService = userService;
        this.userPaging = userPaging;
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

    @GetMapping("/search")
    public Page<EntityDTO> searchUsers(
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String user_name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CreateUser> users = userPaging.findBy(position, user_name, pageable);
        return users.map(userMapper::toDTO);
    }
}




