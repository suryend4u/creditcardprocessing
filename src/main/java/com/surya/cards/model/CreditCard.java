package com.surya.cards.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="CREDIT_CARD")
public class CreditCard implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARD_ID")
	private int cardId;
	
	@Column(name = "CARD_NUMBER")
	private String cardNumber;
	
	@Column(name = "CARDHOLDER_NAME")
	private String cardHolderName;
	
	@Column(name = "BALANCE")
	private Double balance;
	
	@Column(name = "UPPER_LIMIT")
	private Double upperLimit;
	

}
