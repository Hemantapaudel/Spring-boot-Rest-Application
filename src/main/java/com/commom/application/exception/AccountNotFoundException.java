package com.commom.application.exception;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8546840927111074990L;

	public AccountNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}