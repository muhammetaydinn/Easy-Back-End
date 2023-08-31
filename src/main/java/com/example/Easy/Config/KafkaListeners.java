package com.example.Easy.Config;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
@Component
public class KafkaListeners {
    @KafkaListener(topics = "53",
    groupId = "groupId")
    private void listener(String data){
        System.out.println(data);
    }
}
