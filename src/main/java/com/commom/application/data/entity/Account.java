package com.commom.application.data.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
public class Account {

	@Id
	String id;
	
	String accountType;
	String accountNumber;
	double balaceAmmount;
	LocalDateTime dateTime;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalaceAmmount() {
		return balaceAmmount;
	}

	public void setBalaceAmmount(double balaceAmmount) {
		this.balaceAmmount = balaceAmmount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
