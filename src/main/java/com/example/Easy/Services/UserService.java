package com.example.Easy.Services;

import com.example.Easy.Mappers.UserMapper;
import com.example.Easy.Models.DeviceDTO;
import com.example.Easy.Models.UserDTO;
import com.example.Easy.Repository.UserRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository UserRepository;
    private  final UserMapper UserMapper;


    public void addNewUser(UserDTO userDTO) {
        UserRepository.save(UserMapper.toUserEntity(userDTO));
    }
}
