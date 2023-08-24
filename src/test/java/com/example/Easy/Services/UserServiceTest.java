package com.example.Easy.Services;
import com.example.Easy.Models.UserDTO;
import com.example.Easy.Entities.UserEntity;
import com.example.Easy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void addNewUserTest(){
        String token = "eYsHNOnxQ3K83vJB5vCkwQ:APA91bFp2N_MRa3penVKoSfFSCQl1er3FSZtfhTFKP-NcRWrtMIxhumE9Dp5NE2MoU2A-7Z-8XG_6LQ4r4GgPe3Nl7Q-byJBe92xbLZ3m_BGEMZb2xC_BkyDA63D_yzdqnd7RPxfJbZc";
        System.out.println(token.length());
        UserEntity userEntity = UserEntity.builder()
                .userid(UUID.fromString("0f14d0ab-9605-4a62-a9e4-5ed124389b"))
                .image("")
                .name("davut")
                .userToken("5r3245")
                .build();
        userRepository.save(userEntity);
    }
    @Test
    void deleteUserTest(){
        String token = "eYsHNOnxQ3K83vJB5vCkwQ:APA91bFp2N_MRa3penVKoSfFSCQl1er3FSZtfhTFKP-NcRWrtMIxhumE9Dp5NE2MoU2A-7Z-8XG_6LQ4r4GgPe3Nl7Q-byJBe92xbLZ3m_BGEMZb2xC_BkyDA63D_yzdqnd7RPxfJbZc";
        System.out.println(token.length());
        UserEntity userEntity = UserEntity.builder()
                .userid(UUID.fromString("b6565f46-3f0b-4811-99f5-6fbefaebf0ad"))
                        .build();

        userRepository.delete(userEntity);
        assertFalse(userRepository.existsById(userEntity.getUserid()));
    }
}
