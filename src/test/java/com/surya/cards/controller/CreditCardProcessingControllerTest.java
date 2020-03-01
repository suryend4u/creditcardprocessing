package com.surya.cards.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.surya.cards.exception.InvalidCreditCardException;
import com.surya.cards.exception.NewBalanceNotZeroException;
import com.surya.cards.model.CreditCard;
import com.surya.cards.service.CreditCardService;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardProcessingControllerTest {

	@InjectMocks
	CreditCardProcessingController creditCardProcessingController;

	@Mock
	CreditCardService creditCardService;

	@Test
	public void addCreditCardTestForZeroBalance() {

		CreditCard creditCard1 = new CreditCard();
		creditCard1.setCardId(1);
		creditCard1.setCardNumber("5546370227519912");
		creditCard1.setCardHolderName("NK Das");
		creditCard1.setBalance(0.0);
		creditCard1.setUpperLimit(100000.00);

		when(creditCardService.addCreditCard(creditCard1)).thenReturn(creditCard1);
		// TEST
		ResponseEntity<String> result = creditCardProcessingController.addCreditCard(creditCard1);
		assertEquals(result.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test(expected = NewBalanceNotZeroException.class)
	public void addCreditCardTestForNonZeroBalance() {

		CreditCard creditCard1 = new CreditCard();
		creditCard1.setCardId(1);
		creditCard1.setCardNumber("5546370227519912");
		creditCard1.setCardHolderName("NK Das");
		creditCard1.setBalance(80.0);
		creditCard1.setUpperLimit(100000.00);
		
		creditCardProcessingController.addCreditCard(creditCard1);		
	}
	
	@Test(expected = InvalidCreditCardException.class)
	public void addCreditCardTestForInvalidCard() {

		CreditCard creditCard1 = new CreditCard();
		creditCard1.setCardId(1);
		creditCard1.setCardNumber("4567123487651234");
		creditCard1.setCardHolderName("NK Das");
		creditCard1.setBalance(0.0);
		creditCard1.setUpperLimit(100000.00);
		
		creditCardProcessingController.addCreditCard(creditCard1);		
	}

}
