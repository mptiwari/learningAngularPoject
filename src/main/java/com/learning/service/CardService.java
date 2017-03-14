package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.domain.Card;
import com.learning.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
	
	public boolean addCard(Card card) {
		System.out.println("service is coming");
		cardRepository.manageCard(card);
		return true;
	}

	public List<Card> getAllCards() {
		
		return cardRepository.getAllCards();
	}

	public void deleteCard(int cardno) {
		
		System.out.println("deleting card details");
		cardRepository.deleteCard(cardno);
	}

	public void saveCard(Card card) {

		System.out.println("edit card details" + card.getCardno());
		cardRepository.saveCard(card);
	}

}
