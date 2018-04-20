package cards.card.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cards.card.model.Card;
import cards.card.model.Family;
import cards.card.controller.FamilyService;
//controller gérant la methode REST des url

@RestController
public class CardsRestController {
	
	@Autowired//lie automatiquement cardService avec la classe CardService
	private CardsService CardsService;
	
	@Autowired
	private FamilyService familyService;

	/**
	 * 
	 * @return envoie toutes les cartes en json
	 */
	@RequestMapping("/cards")
	private List<Card> getAllCards() {
		return CardsService.getAllCards();
	}
	
	/**
	 * 
	 * @param name
	 * @return recupere carte avec le nom
	 */
	@RequestMapping("/card/name/{name}")
	private List<Card> getCardbyname(@PathVariable String name) {
	  
		return CardsService.getCardByName(name);
		
		}
	/**
	 * 
	 * @param id
	 * @return la carte
	 */
	@RequestMapping("/card/{id}")
	private Card getCard(@PathVariable Integer id) {
	return CardsService.getCardbyid(id);
	}
	/**
	 * ajoute une Card reçu à la base de données
	 * @param card
	 */
	/*
	@RequestMapping(method=RequestMethod.POST,value="/cards")
	public void addCard(@RequestBody Card card) {
		CardsService.addCard(card);
	}*/
	
	@PostMapping("/cards")
	public ResponseEntity<Void> addCard(@RequestBody Card card) {
		CardsService.addCard(card);


		if (card == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(card.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	
	/**
	 *  modifie une carte
	 * @param card
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/update_card/{id}")
	public void updateCard(@RequestBody Card card,@PathVariable  Integer id) {
		card.setId(id);
		CardsService.updateCard(card);
	}
	/**
	 * 	supprime de la base de données la Card correspondant à l'id 
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="/delete_card/{id}")
	public void deleteCard(@PathVariable Integer id) {
		CardsService.deleteCard(id);
	}
	
	/**
	 * 
	 * @param id1
	 * @param id2
	 * @return la valeur de l'attaque si la force de la carte 1 corrsepond a la faiblesse de la carte de on augmente la valeur de l'attaque de 15%
	 * sinon on la baisse de 15%
	 */
	@RequestMapping("/card/attack/{id1}/{id2}")
	private double getAttackValue(@PathVariable Integer id1,@PathVariable Integer id2) {
		Card card1=CardsService.getCardbyid(id1);
		Card card2=CardsService.getCardbyid(id2);
		Family family1=familyService.getFamily(card1.getFamily());
		Family family2=familyService.getFamily(card2.getFamily());

		String strength=family1.getStrength();
		String weakness=family2.getWeakness();
		double attackValue=card1.getAttack();
	
		if(strength.equals(weakness)) {
			attackValue=attackValue*1.15;
		}
		else {
			attackValue=attackValue*0.85;
		}
		
		
		return attackValue;
		
		}

}
