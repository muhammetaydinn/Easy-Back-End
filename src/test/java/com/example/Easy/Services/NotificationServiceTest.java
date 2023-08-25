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
        String toke ="da37GPpPQR2t325Jg8sR-v:APA91bGcvhE_J3gX2udxEPJWgeR_M5e4y_jXpWlNozJnann2493qPn_1mewKchPvigMofwSLBH5PAr-msEL8DZbvURberbuA6667jsk-53JPvPlK5ugbvkSlP0CBADXW8xOLAbFq5lZa";
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .userToken(toke)
                .title("Omer")
                .text("...")
                .image("...")
                .build();
        String response = notificationService.sendNotificationByToken(notificationDTO);
        System.out.println(response);
    }

    @Test
    void subscribteToTopic() throws FirebaseMessagingException {
        String token ="fgiMSYssSZu_i4DjI3wxY5:APA91bH5Ylp92cYdZVBHoEqozkbBQ1-EGQI2JMTdmReLeMUFPqNsq1T8OIvBDasBGZjI_aFTeEhQU2lAtqGKVjong8YIUvBckiHvn-GjgVbvF9I0Ih1y316xtARCr_Ys50w8HE-Fy5nC";
        notificationService.subscribeToTopic("MACHINE_LEARNING",token);
    }

    @Test
    void sendNotificationByTopic() throws FirebaseMessagingException {
        String token ="fgiMSYssSZu_i4DjI3wxY5:APA91bH5Ylp92cYdZVBHoEqozkbBQ1-EGQI2JMTdmReLeMUFPqNsq1T8OIvBDasBGZjI_aFTeEhQU2lAtqGKVjong8YIUvBckiHvn-GjgVbvF9I0Ih1y316xtARCr_Ys50w8HE-Fy5nC";
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .image("img")
                .text("sent by topic")
                .title("Topic Messaging")
                .topic("MACHINE_LEARNING")
                .build();
        notificationService.sendNotificationByTopic(notificationDTO);
    }

}