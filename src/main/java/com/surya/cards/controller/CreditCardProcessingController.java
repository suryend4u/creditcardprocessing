package com.surya.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surya.cards.model.CreditCard;
import com.surya.cards.service.CreditCardService;
import com.surya.cards.validation.CreditCardUtilValidator;

@RestController
public class CreditCardProcessingController {

	@Autowired
	CreditCardService creditCardService;

	@PostMapping("/cards")
	public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard card) {

		if (CreditCardUtilValidator.isvalidCreditCardNumber(card.getCardNumber())) {
			CreditCard savedCard = creditCardService.addCreditCard(card);
			return new ResponseEntity<CreditCard>(savedCard, HttpStatus.CREATED);
		}
		return new ResponseEntity<CreditCard>(card, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/cards")
	public ResponseEntity<List<CreditCard>> getAllCards() {

		List<CreditCard> cardList = creditCardService.getAllCreditCards();
		return new ResponseEntity<List<CreditCard>>(cardList, HttpStatus.OK);

	}

}
