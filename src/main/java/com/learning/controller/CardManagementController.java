package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.domain.Card;
import com.learning.service.CardService;

@RestController
public class CardManagementController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	public ResponseEntity<String> addCard(@RequestBody Card card) {
		System.out.println("coming here"+ card.getCardno());
		boolean flag = cardService.addCard(card);
		System.out.println(flag);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		String message = "Card added successfully";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/saveCard", method = RequestMethod.POST)
	public ResponseEntity<String> saveCard(@RequestBody Card card){
		cardService.saveCard(card);
		String message = "Card details updated successfully: " +card.getCardno();
		System.out.println(message);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/delete/{cardno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCard(@PathVariable("cardno") int cardno){
		System.out.println("deleting card----");
		cardService.deleteCard(cardno);
		String message = "Card deleted successfully" + cardno;
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewCard", method = RequestMethod.GET)
	public ResponseEntity<List<Card>> viewCard(){
		System.out.println("list of card");
		List<Card> cards =  cardService.getAllCards();
		for(Card c : cards){
			System.out.println(c.getCardno());
		}
		return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
		
	}
	
	
}
