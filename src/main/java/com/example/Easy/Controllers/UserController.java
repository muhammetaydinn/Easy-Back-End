package com.example.Easy.Controllers;

import com.example.Easy.Entities.UserEntity;
import com.example.Easy.Models.UserDTO;
import com.example.Easy.Services.UserService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    public ResponseEntity addNewUser(@RequestBody UserDTO userDTO){
        userService.addNewUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
