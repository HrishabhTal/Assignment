package com.project.wallet.service;

import java.util.List;
import com.project.wallet.exchange.Transactiontdo;
import com.project.wallet.exchange.Wallettdo;

public interface WalletService {
     public String withdraw(String name,Float amount);

     public String credit(String name,Float amount);

     public List<Transactiontdo> transactionts(String name);

     public Wallettdo showBalance(String name);

     
}
