package com.project.wallet.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.project.wallet.data.WalletEntity;
import com.project.wallet.repository.TransactionRepository;
import com.project.wallet.repository.WalletRepository;


public class WalletServiceTest {
     @Mock
      private WalletRepository walletRepository;

      @Mock
      private TransactionRepository transactionRepository;

      @InjectMocks
      private WalletServiceImpl walletService;

       @BeforeEach
   
      public void init() {
       MockitoAnnotations.openMocks(this);
      }

    @Test
    public void testCreditSuccess() {
   
    String name = "John Doe";
    Float amount = 100.0f;
    WalletEntity wallet = new WalletEntity();
    wallet.setBalance(50.0f);
    when(walletRepository.getByname(name)).thenReturn(wallet);
    when(walletRepository.save(wallet)).thenReturn(wallet);

   
    String result = walletService.credit(name, amount);

   
    assertEquals("Success", result);
    assertEquals(150.0f, wallet.getBalance());
    }
    
    @Test
    public void testCreditExceedLimit() {
   // Given
    String name = "John Doe";
    Float amount = 100.0f;
    WalletEntity wallet = new WalletEntity();
    wallet.setBalance(4000001f);
    when(walletRepository.getByname(name)).thenReturn(wallet);

   
    String result = walletService.credit(name, amount);

   
    assertEquals("Maximum Limit Reached", result);
    assertEquals(4000001f, wallet.getBalance());
}
   
}
