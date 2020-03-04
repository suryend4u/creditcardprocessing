package com.surya.cards.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surya.cards.model.CreditCard;
import com.surya.cards.service.CreditCardService;

@RunWith(SpringRunner.class)
@WebMvcTest(CreditCardProcessingController.class)
public class CreditCardProcessingControllerEndpointTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CreditCardService creditCardService;

	@Test
	public void getAllCardsAPI() throws Exception {
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
		creditCardList.add(creditCard2);
		creditCardList.add(creditCard3);

		when(creditCardService.getAllCreditCards()).thenReturn(creditCardList);

		mockMvc.perform(MockMvcRequestBuilders.get("/cards").secure(true).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$[0].cardNumber", is("123456678890")))
				.andExpect(jsonPath("$[1].cardNumber", is("5546334698757699")))
				.andExpect(jsonPath("$[2].cardNumber", is("4567987612345678")));
	}

	@Test
	public void createCardAPI() throws Exception {
		CreditCard creditCard3 = new CreditCard();
		creditCard3.setCardNumber("5546370227519912");
		creditCard3.setCardHolderName("Gouri Das");
		creditCard3.setBalance(0.0);
		creditCard3.setUpperLimit(120000.00);

		when(creditCardService.addCreditCard(creditCard3)).thenReturn(creditCard3);

		mockMvc.perform(MockMvcRequestBuilders.post("/cards").secure(true).content(asJsonString(creditCard3))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
