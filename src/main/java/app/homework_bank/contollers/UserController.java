package app.homework_bank.contollers;

import app.homework_bank.DTO.UserDTO;
import app.homework_bank.entities.UserEntity;
import app.homework_bank.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserDTO dto) {
            return ResponseEntity.ok(userService.createUser(dto));
    }


    @GetMapping
    public ResponseEntity<UserEntity> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteUser(@RequestParam Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Map.of("message", "User deleted"));
    }
}
