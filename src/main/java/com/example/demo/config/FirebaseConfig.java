package com.example.demo.config;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
		@PostConstruct
		public void initFirebase() {
			System.out.println("initFirebase START");
			try {
				FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");
				
				FirebaseOptions options = FirebaseOptions.builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.setDatabaseUrl("https://spring-boot-api-server-default-rtdb.firebaseio.com/")
						.build();
				
				FirebaseApp.initializeApp(options);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
