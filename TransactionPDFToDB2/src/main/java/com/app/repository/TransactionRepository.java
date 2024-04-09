package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom methods if needed
}

