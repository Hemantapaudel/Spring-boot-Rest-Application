package com.commom.application.model;

import java.time.LocalDateTime;
public class Account {

	String accountType;
	String accountNumber;
	double balaceAmmount;
	LocalDateTime dateTime;

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
