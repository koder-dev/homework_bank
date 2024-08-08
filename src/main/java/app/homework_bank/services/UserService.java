package app.homework_bank.services;

import app.homework_bank.DTO.UserDTO;
import app.homework_bank.entities.UserEntity;
import app.homework_bank.exceptions.UserNotFoundException;
import app.homework_bank.repositories.UserRepo;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity createUser(UserDTO dto) {
        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        return userRepo.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

}
