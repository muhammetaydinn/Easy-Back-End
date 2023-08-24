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
                .userToken("e_5VwVHYRJG8J3GrGdxmol:APA91bG09ABYw_kKPPBZUCCpZddOPzB2b9Edyhl562UCSqwd4uLSFmFMoDwiE0fyobpZ4TkCGw-dbIs_dyHf3rp5Gu05hCN2X-_y18GTWoR0_ZKnuIvWlh3dmIUnYqRiJEmKOf8ar7oU")
                .title("Title")
                .text("deneme123")
                .image("")
                .build();
        String response =
                notificationService.sendNotificationByToken(notificationDTO);
        System.out.println(response);
    }

}