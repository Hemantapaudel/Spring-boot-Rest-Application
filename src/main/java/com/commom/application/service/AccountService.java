package com.commom.application.service;

import java.util.List;

import com.commom.application.data.entity.Account;

public interface AccountService {
 
	Account create(Account account);
 
	Account delete(String id);
 
    List<Account> findAll();
 
    Account findById(String id);
 
    Account update(Account todo);
}