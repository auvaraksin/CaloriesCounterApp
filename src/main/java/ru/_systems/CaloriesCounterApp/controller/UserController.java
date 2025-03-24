package ru._systems.CaloriesCounterApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru._systems.CaloriesCounterApp.interfaces.UserService;
import ru._systems.CaloriesCounterApp.models.User;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;}

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @GetMapping
    public ResponseEntity getUsers(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            User user = userService.getUserById(userId);
            if(user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(userService.getUsersAll());
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if (updateUser == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}