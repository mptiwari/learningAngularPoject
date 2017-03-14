package com.learning.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.learning.domain.Card;

@Repository
public class CardRepository {

	@Autowired
	private MongoOperations mongoOperations;

	public void manageCard(Card card) {
		System.out.println("before save in mongo");
		mongoOperations.save(card);
		System.out.println("after save in mongo");
	}
	
	public List<Card> getAllCards() {
		List<Card> cards =  mongoOperations.findAll(Card.class);
		return cards;
	}

	public void deleteCard(int cardno) {

		mongoOperations.remove(cardno);
	}

	public void saveCard(Card card) {

		mongoOperations.save(card);
		
	}
	

}
