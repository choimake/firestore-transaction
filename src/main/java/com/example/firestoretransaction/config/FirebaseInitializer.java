package com.example.firestoretransaction.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirebaseInitializer {

  @Value("${firestore.project-id}")
  private String projectId;

  @PostConstruct
  public void initialize() {
    try {
      // Google Cloud SDKによるデフォルト認証情報を使用
      FirebaseOptions options = FirebaseOptions.builder()
          .setCredentials(GoogleCredentials.getApplicationDefault())
          .setProjectId(projectId)
          .build();

      // FirebaseAppの初期化（すでに初期化されている場合はスキップ）
      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
