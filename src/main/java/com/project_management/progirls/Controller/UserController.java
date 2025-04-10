package com.project_management.progirls.Controller;

import com.project_management.progirls.Models.User;
import com.project_management.progirls.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Rota para o GET
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(200).body(userService.userList());
    }

    // Rota para o GET pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Rota para o POST
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(200).body(userService.createUser(user));
    }

    // Rota para o PUT/EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updateUser = userService.updateUser(id, userDetails);
        if (updateUser != null) {
            return ResponseEntity.ok(updateUser);
        }
        return ResponseEntity.notFound().build();
    }

    // Rota para o DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> userDelete(@PathVariable Long id)  {
        userService.userDelete(id);
        return ResponseEntity.status(204).build();
    }
}
