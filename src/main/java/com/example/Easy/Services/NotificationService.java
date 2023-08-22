package com.example.Easy.Services;

import com.example.Easy.Models.NotificationDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class NotificationService {
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(NotificationDTO notificationDTO) throws FirebaseMessagingException {

        //Writing notifications into firebase, not required we can remote it later.
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("Notification")
                .document(notificationDTO.getTitle()).create(notificationDTO);

        //build notification from notificationDTO
        Notification notification = Notification.builder()
                .setTitle(notificationDTO.getTitle())
                .setBody(notificationDTO.getBody())
                .build();
        //build message by using notification and a recipient token
        Message message = Message.builder()
                .setToken(notificationDTO.getUserToken())
                .setNotification(notification)
                .putAllData(notificationDTO.getData())
                .build();
        //firebase handles the sending procedure
        return firebaseMessaging.send(message);
    }

    //Search sent notifications in firebase database, can switch to H2 later.
    public  NotificationDTO getMessageByTopic(String topic) throws ExecutionException, InterruptedException {
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

}
