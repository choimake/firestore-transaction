package com.example.firestoretransaction.repository.user;

import com.example.firestoretransaction.domain.user.User;
import com.example.firestoretransaction.repository.firestore.TransactionContext;

public interface UserRepository {
  void saveUser(TransactionContext transaction, User user);
}
