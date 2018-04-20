package cards.card.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cards.card.model.Card;
//interface permettant de faire des requète vers la table Card de la base de données

public interface CardsRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	
	public Card findOne(Integer id);

}
