package com.project.wallet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.wallet.exchange.Deposit;
import com.project.wallet.exchange.Transactiontdo;
import com.project.wallet.exchange.Withdrawal;
import com.project.wallet.service.WalletService;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WalletController {
    
    @Autowired
    private final WalletService walletService;

	@RequestMapping(value="withdraw", method = RequestMethod.POST)
	public String Withdraw(ModelMap model, @Valid Withdrawal withdrawal, BindingResult result) {
		
		if(result.hasErrors()) {
			return "mainpage";
		}
		
		String username = getLoggedInUsername(model);
	    String process = walletService.withdraw(username, withdrawal.getAmount());
		model.put("message", process);
		
		return "message";
	}

	@RequestMapping(value="deposit", method = RequestMethod.POST)
	public String Deposit(ModelMap model, @Valid Deposit deposit , BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("deposit", deposit);
			return "mainpage";
		}
		
		String username = getLoggedInUsername(model);
		String process = walletService.credit(username, deposit.getAmount());

		model.put("message", process);
		
		return "message";
	}

	@RequestMapping("transactions")
	public String listAllTransactions(ModelMap model) {
		String username = getLoggedInUsername(model);
				
		List<Transactiontdo> todo = walletService.transactionts(username);
		model.addAttribute("todo", todo);
		
		return "transactions";
	}
    
    private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
