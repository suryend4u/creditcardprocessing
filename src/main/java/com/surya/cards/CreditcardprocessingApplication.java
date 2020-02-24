package com.surya.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.surya.cards.service.CreditCardService;
import com.surya.cards.service.CreditCardServiceImpl;

@SpringBootApplication
public class CreditcardprocessingApplication {
	
	@Bean
	CreditCardService getCreditCardService() {
		return new CreditCardServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(CreditcardprocessingApplication.class, args);
	}

}
