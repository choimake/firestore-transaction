package com.example.firestoretransaction.runner;

import com.example.firestoretransaction.usecase.UserUseCase;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

  private final UserUseCase userUseCase;

  public AppRunner(UserUseCase userUseCase) {
    this.userUseCase = userUseCase;
  }

  @Override
  public void run(String... args) {

    String id = UUID.randomUUID().toString();
    String name = args[0];

    userUseCase.createUserWithTransaction(id, name);
    System.out.println("User created successfully");
  }
}
