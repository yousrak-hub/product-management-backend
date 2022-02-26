package com.tuto.service;

import java.util.List;

import com.tuto.model.Transaction;

public interface TransactionService {

	Transaction saveTransaction(Transaction transaction);

	long numberOfTransactions();

	List<Transaction> findAllTransactions();

}
