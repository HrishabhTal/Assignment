package com.project.wallet.service;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.project.wallet.data.TransactionEntity;
import com.project.wallet.data.WalletEntity;
import com.project.wallet.exchange.Transactiontdo;
import com.project.wallet.exchange.Wallettdo;
import com.project.wallet.repository.TransactionRepository;
import com.project.wallet.repository.WalletRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class WalletServiceImpl implements WalletService {
    
    @Autowired
    private final WalletRepository walletRepository;

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final String LOW_BALANCE = "Insufficient Balance";
    private final String ACCOUNT_LIMIT = "Maximum Limit Reached";
    private final String SUCCESS = "Success";
    private final Float MAXIMUM = 4000000f;
    
    
    public String withdraw(String name,Float amount){
        
        WalletEntity wallet = walletRepository.getByname(name);

        Float balance = wallet.getBalance();

        if(balance < amount){
            return LOW_BALANCE;
        }
        
        wallet.setBalance(balance-amount);
        walletRepository.save(wallet);
        
        TransactionEntity transaction = new TransactionEntity();
        transaction.setName(name);
        transaction.setAmount(amount);
        transaction.setType("Debited");

        transactionRepository.save(transaction);

        return SUCCESS;

    }

    public String credit(String name,Float amount){
        
        WalletEntity wallet = walletRepository.getByname(name);

        Float balance = wallet.getBalance();

        if(balance + amount > MAXIMUM){
            return ACCOUNT_LIMIT;
        }
        
        wallet.setBalance(balance+amount);
        walletRepository.save(wallet);

        TransactionEntity transaction = new TransactionEntity();
        transaction.setName(name);
        transaction.setAmount(amount);
        transaction.setType("Credited");

        transactionRepository.save(transaction);

        return SUCCESS;

    }

    public List<Transactiontdo> transactionts(String name){
        List<Transactiontdo> transactiontdtos = new ArrayList<>();

        List<TransactionEntity> transactionEntities = transactionRepository.findByname(name);

        for(TransactionEntity transactionEntity : transactionEntities ){
            
            transactiontdtos.add(this.modelMapper.map(transactionEntity , Transactiontdo.class));
        }

        return transactiontdtos;
    }

    public Wallettdo showBalance(String name){

        WalletEntity wallet = walletRepository.getByname(name);
        
        return this.modelMapper.map(wallet, Wallettdo.class);
    
    }


   

}
