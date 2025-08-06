package backend.service;

import backend.model.CreateUser;
import backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public CreateUser updateUser(Long userId, CreateUser updateUser, MultipartFile image) {
        return userRepository.findById(userId).map(user -> {
            if (updateUser.getUserName() != null) {
                user.setUserName(updateUser.getUserName());
            }

            if (updateUser.getEmail() != null) {
                user.setEmail(updateUser.getEmail());
            }

            if (updateUser.getPassword() != null) {
                user.setPassword(updateUser.getPassword());
            }

            if (updateUser.getPosition() != null) {
                user.setPosition(updateUser.getPosition());
            }

            if (updateUser.getPhoneNumber() != null) {
                user.setPhoneNumber(updateUser.getPhoneNumber());
            }

            if (image != null && !image.isEmpty()) {
                try {
                    user.setAvatarImg(image.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to read avatar image", e);
                }
            }



            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }


}