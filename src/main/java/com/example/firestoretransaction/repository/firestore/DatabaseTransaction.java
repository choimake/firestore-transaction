package com.example.firestoretransaction.repository.firestore;

public interface DatabaseTransaction {
  <T> void runInTransaction(TransactionCallable<T> transactionCallable);
}
