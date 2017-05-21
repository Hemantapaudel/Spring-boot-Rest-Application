package com.commom.application.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import com.commom.application.data.entity.Account;

public interface AccountRepository extends Repository<Account, String> {
	   void delete(Account account);
	   
	    List<Account> findAll();
	 
	    Optional<Account> findOne(String id);
	 
	    Account save(Account saved);
	    
}
