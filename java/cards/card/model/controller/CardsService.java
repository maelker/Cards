package cards.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cards.card.model.Card;


@Service
public class CardsService {

	@Autowired
	private CardsRepository cardsRepository;
	public List<Card> getAllCards() {
		List<Card> cards = new ArrayList<>();
		cardsRepository.findAll().forEach(cards::add);
		return cards;
	}

	public List<Card> getCardByName(String name) {
		 List<Card> card=cardsRepository.findByName(name);
		return card;
	}

	public Card addCard(Card card) {
		cardsRepository.save(card);
		return card;
	}

	public void updateCard(Card card) {
		cardsRepository.save(card);

	}

	public void deleteCard(Integer id) {
		cardsRepository.delete(id);
	}

	public Card getCardbyid(int id) {
		return cardsRepository.findOne(id);
	}
	
	

	   
	

}
