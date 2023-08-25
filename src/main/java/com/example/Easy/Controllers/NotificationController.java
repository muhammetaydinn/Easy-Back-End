package com.example.Easy.Controllers;

import com.example.Easy.Models.NotificationDTO;
import com.example.Easy.Services.NotificationService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public void postNotificationByToken(@RequestBody NotificationDTO notificationMessage) throws FirebaseMessagingException {
        notificationService.sendNotificationByToken(notificationMessage);
    }
    @GetMapping("{title}")
    public ResponseEntity getNotificationByTopic(@PathVariable("title") String title) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(notificationService.getMessageByTitle(title));
    }

    @PostMapping("/subscribe/{topic}")
    public ResponseEntity subscribeToTopic(@PathVariable("topic") String topic,@RequestBody String token) throws FirebaseMessagingException {
        notificationService.subscribeToTopic(topic,token);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}