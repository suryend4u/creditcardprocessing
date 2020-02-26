package com.surya.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCreditCardException extends RuntimeException {

	private static final long serialVersionUID = 1245944171400719234L;

	public InvalidCreditCardException(String exception) {
		super(exception);
	}
}
