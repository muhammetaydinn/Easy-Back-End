package com.example.Easy.Services;

import com.example.Easy.Mappers.UserMapper;
import com.example.Easy.Models.UserDTO;
import com.example.Easy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public void createNewUser(UserDTO userDTO) {
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
}
