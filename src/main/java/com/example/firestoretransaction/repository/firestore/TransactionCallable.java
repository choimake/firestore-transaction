package com.example.firestoretransaction.repository.firestore;

@FunctionalInterface
public interface TransactionCallable<T> {
  T call(TransactionContext transaction) throws Exception;
}
