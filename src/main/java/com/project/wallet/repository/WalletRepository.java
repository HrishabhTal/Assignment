package com.project.wallet.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.wallet.data.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {

    WalletEntity getByname(String name);
    
}
