package com.example.Easy.Controllers;

import com.example.Easy.Models.UserDTO;
import com.example.Easy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity createNewUser(@RequestBody UserDTO userDTO){
        //TODO cant bootstrap data since a real FCM is needed
        userService.createNewUser(userDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId")UUID userId){
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("{userId}")
    public UserDTO getUserById(@PathVariable("userId") UUID userId){
        return userService.getUserById(userId);
    }
}
