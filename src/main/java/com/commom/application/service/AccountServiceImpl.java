package com.commom.application.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commom.application.data.entity.Account;
import com.commom.application.data.repository.AccountRepository;
import com.commom.application.exception.*;

import java.util.List;
import java.util.Optional;
 
@Service
public final class AccountServiceImpl implements AccountService {
 
    private final AccountRepository repository;
 
    @Autowired
    AccountServiceImpl(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }
 
    @Override
    public Account create(Account account) {        
         return repository.save(account);
    }
 
    @Override
    public Account delete(String id) {
    	Account deleted = findTodoById(id);
        repository.delete(deleted);
        return deleted;
    }
 
    @Override
    public List<Account> findAll() {
        List<Account> accounts = repository.findAll();
        return accounts;
    }
 
    
 
    @Override
    public Account findById(String id) {
    	Account found = findTodoById(id);
        return found;
    }
 
    @Override
    public Account update(Account account) {
    	Account updated = findTodoById(account.getId());
        updated.setAccountNumber(account.getAccountNumber());
        updated.setAccountType(account.getAccountType());
        updated.setDateTime(account.getDateTime());
        updated = repository.save(updated);
        return updated;
       }
 
    private Account findTodoById(String id) {
        Optional<Account> result = repository.findOne(id);
        return result.orElseThrow(() -> new AccountNotFoundException(id));
 
    }
 
}