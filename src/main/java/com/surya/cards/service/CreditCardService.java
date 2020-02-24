package com.surya.cards.service;

import java.util.List;

import com.surya.cards.model.CreditCard;

public interface CreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditCard);
	
	public List<CreditCard> getAllCreditCards();

}
