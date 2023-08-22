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
                .userToken("ev3LWR4UTRyiZxCecDrTPH:APA91bEOMuCZkd37_xC4QCAIERdjBgxRU1k0GldC2p1DT5EcBmrPPlfZbuvn92hP1U0XhPnWLoo_O51ItqAw-RgJDvnrefoyAtvgWTTMsNJP6Yo5Ow-aDTt4F8ngHAUkQCg-bvW6V6cv")
                .title("Title")
                .body("First Notification")
                .image("")
                .build();
        String response =
                notificationService.sendNotificationByToken(notificationDTO);
        System.out.println(response);
    }

}