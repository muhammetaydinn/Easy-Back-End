package com.example.Easy.Services;

import com.example.Easy.Entities.UserEntity;
import com.example.Easy.Mappers.UserMapper;
import com.example.Easy.Models.UserDTO;
import com.example.Easy.Repository.UserRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    NotificationService notificationService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public void createNewUser(UserDTO userDTO){
        //TODO cant since a real FCM token is needed
        //notificationService.subscribeToTopic("All",userDTO.getUserToken());
        userRepository.save(userMapper.toUserEntity(userDTO));
    }

    public void deleteUser(UUID userId){
        userRepository.deleteById(userId);
    }

    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID userId) {
        return userMapper.toUserDTO(userRepository.findById(userId).orElse(null));
    }
    public void patchUserById(UUID userId, UserDTO userDTO) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if(user==null)
                return;
        if(userDTO.getUserToken()!=null && !userDTO.getUserToken().equals(""))
            user.setUserToken(userDTO.getUserToken());
        if(userDTO.getName()!=null && !userDTO.getName().equals(""))
            user.setName(userDTO.getName());
        if(userDTO.getImage()!=null && !userDTO.getName().equals(""))
            user.setImage(userDTO.getImage());
        if(userDTO.getRole()!=null)
            user.setRole(userDTO.getRole());
        userRepository.save(user);
    }

    public void followUserById(UUID userId, UserDTO userDTO) {
        UserEntity userFollowing = userRepository.findById(userDTO.getUserId()).orElse(null);
        UserEntity userFollowed = userRepository.findById(userId).orElse(null);
        userFollowing.getFollowing().add(userFollowed);
        userFollowed.getFollowers().add(userFollowing);
        userRepository.save(userFollowing);
        userRepository.save(userFollowed);
    }

    public List<UserDTO> getAllFollowers(UUID userId){
        UserEntity user = userRepository.findById(userId).orElse(null);
        return user.getFollowers()
                .stream().map(userMapper::toUserDTO)
                .collect(Collectors.toList());

    }

    public List<UserDTO> getAllFollowing(UUID userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        return user.getFollowing()
                .stream().map(userMapper::toUserDTO)
                .collect(Collectors.toList());

    }
}
