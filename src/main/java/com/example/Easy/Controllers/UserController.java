package com.example.Easy.Controllers;

import com.example.Easy.Models.UserDTO;
import com.example.Easy.Services.UserService;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
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
    public void deleteUserById(@PathVariable("userId") UUID userId){
        userService.deleteUser(userId);
    }
    @PatchMapping("/{userId}")
    public void patchUserById(@PathVariable("userId") UUID userId,@RequestBody UserDTO userDTO){
        userService.patchUserById(userId,userDTO);
    }
    @GetMapping("/all")
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable("userId") UUID userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/follow/{userId}")
    public void followUserById(@PathVariable("userId") UUID userId,@RequestBody UserDTO userDTO){
        userService.followUserById(userId,userDTO);

    }

    @GetMapping("/followers/{userId}")
    public List<UserDTO> getAllFollowersById(@PathVariable("userId") UUID userId){
        return userService.getAllFollowers(userId);
    }
    @GetMapping("/following/{userId}")
    public List<UserDTO> getAllFollowingById(@PathVariable("userId") UUID userId){
        return userService.getAllFollowing(userId);
    }
}
