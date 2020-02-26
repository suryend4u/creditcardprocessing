package com.surya.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surya.cards.exception.InvalidCreditCardException;
import com.surya.cards.model.CreditCard;
import com.surya.cards.service.CreditCardService;
import com.surya.cards.validation.CreditCardUtilValidator;

@RestController
public class CreditCardProcessingController {

	@Autowired
	CreditCardService creditCardService;
	
	@Value("${app.invalid.cardnumber}")
	private String invalidCardNumber;
	
	@Value("${app.cardsave.successful}")
	private String cardsavedMsg;

	@PostMapping("/cards")
	public ResponseEntity<String> addCreditCard(@RequestBody CreditCard card) {

		if(CreditCardUtilValidator.isvalidCreditCardNumber(card.getCardNumber()))
		{
			creditCardService.addCreditCard(card);
			return new ResponseEntity<String>(cardsavedMsg, HttpStatus.CREATED);
		}else {
			throw new InvalidCreditCardException(invalidCardNumber);
		}
		

	}

	@GetMapping("/cards")
	public ResponseEntity<List<CreditCard>> getAllCards() {

		List<CreditCard> cardList = creditCardService.getAllCreditCards();
		return new ResponseEntity<List<CreditCard>>(cardList, HttpStatus.OK);

	}

}
