package web.pocket4cut.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.pocket4cut.entity.User;
import web.pocket4cut.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다.")
        );
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다.")
        );

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다")
        );
        userRepository.delete(user);
        return ResponseEntity.ok().body(user);
    }
}
