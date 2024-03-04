package com.example.firestoretransaction.usecase;

import com.example.firestoretransaction.domain.user.User;
import com.example.firestoretransaction.repository.firestore.DatabaseTransaction;
import com.example.firestoretransaction.repository.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserUseCase {
  private final DatabaseTransaction databaseTransaction;
  private final UserRepository userRepository;

  public UserUseCase(DatabaseTransaction databaseTransaction, UserRepository userRepository) {
    this.databaseTransaction = databaseTransaction;
    this.userRepository = userRepository;
  }

  public void createUserWithTransaction(String id, String name) {
    databaseTransaction.runInTransaction(transaction -> {
      User user = new User();
      user.setId(id);
      user.setName(name);
      userRepository.saveUser(transaction, user);
      // 他のリポジトリ操作もこのトランザクション内で行うことができます
      return null;
    });
  }
}
