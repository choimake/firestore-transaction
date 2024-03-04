package com.example.firestoretransaction.repository.firestore;

import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

@Component
public class FirestoreDatabaseTransaction implements DatabaseTransaction {

  @Override
  public <T> void runInTransaction(TransactionCallable<T> transactionCallable) {
    var db = FirestoreClient.getFirestore();

    try {
      db.runTransaction(transaction -> {
        TransactionContext context = new FirestoreTransactionContext(transaction);
        return transactionCallable.call(context);
      }).get();
    } catch (Exception e) {
      throw new RuntimeException("Transaction failed", e);
    }
  }
}
