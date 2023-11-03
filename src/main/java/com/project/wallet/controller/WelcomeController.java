package com.project.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.wallet.exchange.Deposit;
import com.project.wallet.exchange.Wallettdo;
import com.project.wallet.exchange.Withdrawal;
import com.project.wallet.service.WalletService;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes("name")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WelcomeController {

	 @Autowired
    private final WalletService walletService;
    
    @RequestMapping(value="/",method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		String username = getLoggedinUsername();
		model.put("name", username);

		Wallettdo wallettdo = walletService.showBalance(username);
		model.put("balance", wallettdo.getBalance());
		
		Withdrawal withdrawal = new Withdrawal();
        model.put("withdrawal", withdrawal);

		model.addAttribute("deposit", new Deposit());

		return "mainpage";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}