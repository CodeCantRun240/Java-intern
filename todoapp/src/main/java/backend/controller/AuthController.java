package backend.controller;

import backend.dto.EntityDTO;
import backend.dto.LoginDTO;
import backend.model.CreateUser;
import backend.repository.UserRepository;
import backend.security.CustomUserDetails;
import backend.security.JwtUtil;
import backend.security.SecurityUtil;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import backend.mapper.GetUserMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private final GetUserMapper getUserMapper;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthController(GetUserMapper getUserMapper) {
        this.getUserMapper = getUserMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid EntityDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        CreateUser user = getUserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO ldto) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            ldto.getEmail(), ldto.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
            String token = jwtUtil.generateToken(user, user.getPosition());
            // Create map response
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/admin/data")
    public String getAdminData() {
        return "This is only for admins";
    }

    @PreAuthorize("hasAnyAuthority('user', 'admin')")
    @GetMapping("/user/data")
    public String getUserData() {
        return "User or admin can see this";
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getProfile() {
        String username = SecurityUtil.getCurrentUsername();
        return ResponseEntity.ok("Welcome, " + username);
    }
}
