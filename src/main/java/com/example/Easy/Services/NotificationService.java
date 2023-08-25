package com.example.Easy.Services;

import com.example.Easy.Entities.NotificationEntity;
import com.example.Easy.Mappers.NotificationMapper;
import com.example.Easy.Models.NotificationDTO;
import com.example.Easy.Repository.NotificationRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private  final NotificationRepository notificationRepository;
    private  final NotificationMapper notificationMapper;

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(NotificationDTO notificationDTO) throws FirebaseMessagingException {
        notificationRepository.save(notificationMapper.toNotificationEntity(notificationDTO));
        //build notification from notificationDTO
        Notification notification = Notification.builder()
                .setTitle(notificationDTO.getTitle())
                .setBody(notificationDTO.getText())
                .setImage(notificationDTO.getImage())
                .build();
        //build message by using notification and a recipient token
        Message message = Message.builder()
                .setToken(notificationDTO.getUserToken())
                .setNotification(notification)
                .build();
        //firebase handles the sending procedure
        return firebaseMessaging.send(message);
    }

    //Search sent notifications in firebase database, can switch to H2 later.
    public  NotificationDTO getMessageByTitle(String topic) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("Notification").document(topic);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        NotificationDTO notificationMessage;
        if(documentSnapshot.exists()){
            notificationMessage = documentSnapshot.toObject(NotificationDTO.class);
            return notificationMessage;
        }
        return null;
    }


    public String sendNotificationByTopic(String topic,NotificationDTO notificationDTO) throws FirebaseMessagingException {
        notificationRepository.save(notificationMapper.toNotificationEntity(notificationDTO));
        //build notification from notificationDTO
        Notification notification = Notification.builder()
                .setTitle(notificationDTO.getTitle())
                .setBody(notificationDTO.getText())
                .setImage(notificationDTO.getImage())
                .build();
        //build message by using notification and a recipient token
        Message message = Message.builder()
                .setTopic(topic)
                .setNotification(notification)
                .build();
        //firebase handles the sending procedure
        return firebaseMessaging.send(message);
    }
    public void subscribeToTopic(String topic, String token) throws FirebaseMessagingException {
        firebaseMessaging.subscribeToTopic(Arrays.asList(token),topic);
    }
    public void subscribeToTopic(String topic,List<String> tokens) throws FirebaseMessagingException {
        firebaseMessaging.subscribeToTopic(tokens,topic);
    }
}
