package com.surya.cards.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.surya.cards.model.CreditCard;
import com.surya.cards.repo.CreditCardRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceTest {
	
	@InjectMocks
	CreditCardServiceImpl creditCardService;
	
	@Mock
	CreditCardRepository creditCardRepository;
	
	@Test
	public void getAllCreditCardsTest() {

		List<CreditCard> creditCardList = new ArrayList<>();
		CreditCard creditCard1 = new CreditCard();
		creditCard1.setCardNumber("123456678890");
		creditCard1.setCardHolderName("NK Das");
		creditCard1.setBalance(1876.98);
		creditCard1.setUpperLimit(100000.00);
		
		CreditCard creditCard2 = new CreditCard();
		creditCard2.setCardNumber("5546334698757699");
		creditCard2.setCardHolderName("Surya Das");
		creditCard2.setBalance(1857.09);
		creditCard2.setUpperLimit(110000.00);
		
		CreditCard creditCard3 = new CreditCard();
		creditCard3.setCardNumber("4567987612345678");
		creditCard3.setCardHolderName("Gouri Das");
		creditCard3.setBalance(990.76);
		creditCard3.setUpperLimit(120000.00);
		
		creditCardList.add(creditCard1);
		creditCardList.add(creditCard1);
		creditCardList.add(creditCard1);

		when(creditCardRepository.findAll()).thenReturn(creditCardList);

		// TEST
		List<CreditCard> creditCardListFromService = creditCardService.getAllCreditCards();
		assertEquals(3, creditCardListFromService.size());
	}
	
	@Test
	public void addNewCreditCard()
	{
		CreditCard creditCard1 = new CreditCard();
		creditCard1.setCardId(1);
		creditCard1.setCardNumber("123456678890");
		creditCard1.setCardHolderName("NK Das");
		creditCard1.setBalance(1876.98);
		creditCard1.setUpperLimit(100000.00);
		
		when(creditCardRepository.save(creditCard1)).thenReturn(creditCard1);
		
		//TEST
		CreditCard creditCardSaved = creditCardService.addCreditCard(creditCard1);
		assertEquals(creditCardSaved.getBalance(),creditCard1.getBalance());
		assertEquals(creditCardSaved.getUpperLimit(),creditCard1.getUpperLimit());
		assertEquals(creditCardSaved.getCardHolderName(),creditCard1.getCardHolderName());
		assertEquals(creditCardSaved.getCardNumber(),creditCard1.getCardNumber());
		assertEquals(creditCardSaved.getCardId(),creditCard1.getCardId());
	}

}
