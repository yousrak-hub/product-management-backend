package com.tuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
