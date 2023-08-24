package com.example.Easy.Services;

import com.example.Easy.Models.NotificationDTO;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationServiceTest {

    @Autowired
    NotificationService notificationService;

    @Test
    void sendNotificationByToken() throws FirebaseMessagingException {
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .userToken("eYsHNOnxQ3K83vJB5vCkwQ:APA91bFp2N_MRa3penVKoSfFSCQl1er3FSZtfhTFKP-NcRWrtMIxhumE9Dp5NE2MoU2A-7Z-8XG_6LQ4r4GgPe3Nl7Q-byJBe92xbLZ3m_BGEMZb2xC_BkyDA63D_yzdqnd7RPxfJbZc")
                .title("Title")
                .text("hi")
                .image("image")
                .build();
        String response =
                notificationService.sendNotificationByToken(notificationDTO);
        System.out.println(response);
    }

}