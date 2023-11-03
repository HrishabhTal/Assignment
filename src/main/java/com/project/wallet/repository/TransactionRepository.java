package com.project.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.wallet.data.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> findByname(String name);
    
}
