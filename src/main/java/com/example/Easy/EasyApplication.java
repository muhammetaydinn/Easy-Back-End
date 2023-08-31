package com.example.Easy;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

@SpringBootApplication
public class EasyApplication {


	//Firebase Messaging set-up
	@Bean
	FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
		return FirebaseMessaging.getInstance(firebaseApp);
	}

	@Bean
	public FirebaseApp firebaseApp () throws IOException {
		//Getting credentials from resouce file
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(new ClassPathResource("serviceAccountKey.json").getInputStream()))
				.build();
		return FirebaseApp.initializeApp(options);
	}
	@Bean
	public KafkaAdmin admin() {
		return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"));
	}

	public static void main(String[] args) {
		SpringApplication.run(EasyApplication.class, args);
	}
}
