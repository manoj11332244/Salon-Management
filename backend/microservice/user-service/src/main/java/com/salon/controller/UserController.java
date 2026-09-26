package com.salon.controller;



import com.salon.model.User;

import com.salon.service.UserService;
import lombok.Builder;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("api/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser=userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
        User user=userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
}

    @PutMapping("api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        User updateUser=userService.updateUser(user,id);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id )  throws Exception{
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deletee",HttpStatus.OK);
    }

}

