package com.surya.cards.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardUtilValidatorTest {
	
	@Test
	public void nonLuhnCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("1234567898765432"),false);
	}
	
	@Test
	public void validLuhnCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("79927398713"),true);
	}
	
	@Test
	public void stringCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("123s56sdf8765432"),false);
	}
	
	@Test
	public void gapsCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("12345678 8765 321"),false);
	}
	
	
	@Test
	public void emptyCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber(""),false);
	}
	
	@Test
	public void nullCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber(null),false);
	}
	
	@Test
	public void moreThanMaxLengthCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("389232387468732462837468327462384234872364"),false);
	}
	
	@Test
	public void lessThanMinLengthCreditCardNumberTest() {
	assertEquals(CreditCardUtilValidator.isvalidCreditCardNumber("389232"),false);
	}

}
