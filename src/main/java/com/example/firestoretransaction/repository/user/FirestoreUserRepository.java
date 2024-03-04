package com.example.firestoretransaction.repository.user;

import com.example.firestoretransaction.domain.user.User;
import com.example.firestoretransaction.repository.firestore.TransactionContext;
import org.springframework.stereotype.Component;

@Component
public class FirestoreUserRepository implements UserRepository {

  @Override
  public void saveUser(TransactionContext transaction, User user) {
    transaction.set("users/" + user.getId(), user);
  }
}
