package com.commom.application.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.commom.application.data.entity.Account;
import com.commom.application.data.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	

	@RequestMapping(value = { "getAccounts" }, produces = { "application/json" },
			method = { RequestMethod.GET })
	@ResponseBody
	public List<Account> getAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}

	@RequestMapping(value = { "createAccount" }, produces = {
			"application/json", "application/xml" }, method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Account createAccount(@RequestBody Account account) {
		Account accounts = accountRepository.save(account);
		
		return accounts;
	}

	@RequestMapping(value = "deleteAccount/id/{id}", consumes = { "application/json" },
			method = { RequestMethod.DELETE })
	public void deleteAccount(@PathVariable(value = "id") String id) {
		Optional<Account> account = accountRepository.findOne(id);
		accountRepository.delete(account.get());
	}

	@RequestMapping(value = "updateAccount", produces = { "application/xml" }, method = { RequestMethod.PUT })
	@ResponseBody
	public Account updateAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public void handleTodoNotFound(NoSuchElementException ex) {
	}

}
