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
        String toke ="fgiMSYssSZu_i4DjI3wxY5:APA91bH5Ylp92cYdZVBHoEqozkbBQ1-EGQI2JMTdmReLeMUFPqNsq1T8OIvBDasBGZjI_aFTeEhQU2lAtqGKVjong8YIUvBckiHvn-GjgVbvF9I0Ih1y316xtARCr_Ys50w8HE-Fy5nC";
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .userToken(toke)
                .title("Omer")
                .text("...")
                .image("...")
                .build();
        String response =
                notificationService.sendNotificationByToken(notificationDTO);
        System.out.println(response);
    }

    @Test
    void subscribteToTopic() throws FirebaseMessagingException {
        notificationService.subscribeToTopic("MACHINE_LEARNING","eaDTyUeeS9y1nJVvUbDtJB:APA91bElZZbNIlVIDn67B2JCPVXDMEGmEdJhxtsVDaXIpbOKJ1SpmeSWk0T8Gg4CO7VYToYnhYiVAAN7Io_uVbjTpItncQbIBF2EO_v-H4vryiNJ0fvK45SSuVpT-dPL096X1FYf_pit");
    }

    @Test
    void sendNotificationByTopic() throws FirebaseMessagingException {
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .userToken("eaDTyUeeS9y1nJVvUbDtJB:APA91bElZZbNIlVIDn67B2JCPVXDMEGmEdJhxtsVDaXIpbOKJ1SpmeSWk0T8Gg4CO7VYToYnhYiVAAN7Io_uVbjTpItncQbIBF2EO_v-H4vryiNJ0fvK45SSuVpT-dPL096X1FYf_pit")
                .image("img")
                .text("sent by topic")
                .title("Topic Messaging")
                .build();
        notificationService.sendNotificationByTopic("MACHINE_LEARNING",notificationDTO);
    }

}