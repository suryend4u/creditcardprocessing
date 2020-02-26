package com.surya.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NewBalanceNotZeroException extends RuntimeException {

	private static final long serialVersionUID = 1245944170919234L;

	public NewBalanceNotZeroException(String exception) {
		super(exception);
	}
}