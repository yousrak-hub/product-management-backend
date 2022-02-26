package com.tuto.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.model.Transaction;
import com.tuto.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		transaction.setPurchaseDate(LocalDateTime.now());
		return transactionRepository.save(transaction);
	}

	@Override
	public long numberOfTransactions() {
		return transactionRepository.count();
	}
	
	@Override
	public List<Transaction> findAllTransactions() {
		return transactionRepository.findAll();
	}
}
