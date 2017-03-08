package com.commom.application.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.commom.application.model.Account;

@RestController
public class AccountController {
	
	
	@RequestMapping(value ={"getaccount"},
			produces={"application/json","application/xml"},
			method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Account getAccountWithParam(@RequestParam(value ="account") String account) {
		Account accct = new Account();
		accct.setAccountNumber(account);
		accct.setAccountType("Saving");
		accct.setBalaceAmmount(123564789.23);
		accct.setDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		return accct;
    }
	@RequestMapping(value ="getaccount/account/{account}",
			 produces={"application/xml"},
			 method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Account getAccountWithPathValue(@PathVariable(value ="account") String account) {
		Account accct = new Account();
		accct.setAccountNumber(account);
		accct.setAccountType("Saving");
		accct.setBalaceAmmount(123564789.23);
		accct.setDateTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		return accct;
    }

}
