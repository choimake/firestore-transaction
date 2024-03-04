package com.example.firestoretransaction.repository.firestore;

import com.google.cloud.firestore.Transaction;
import com.google.firebase.cloud.FirestoreClient;

public class FirestoreTransactionContext implements TransactionContext {
  private final Transaction firestoreTransaction;

  public FirestoreTransactionContext(Transaction firestoreTransaction) {
    this.firestoreTransaction = firestoreTransaction;
  }

  @Override
  public void set(String path, Object object) {
    firestoreTransaction.set(FirestoreClient.getFirestore().document(path), object);
  }
}
