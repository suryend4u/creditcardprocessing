package com.surya.cards.repo;

import org.springframework.data.repository.CrudRepository;

import com.surya.cards.model.CreditCard;

public interface CreditCardRepository extends CrudRepository<CreditCard,Integer> {

}
