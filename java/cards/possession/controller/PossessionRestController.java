package cards.possession.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PossessionRestController {
	
	@Autowired
	private PossessionService PossessionService;
	
	
	/**
	 * Cette fonction va faire appel au MicroService Card
	 * afin de récupérer toutes les informations qui
	 * corresspondent à la carte avec l'id : idcard.
	 * @param idcard
	 * @return [allInfoCards] Toutes les informations de la
	 * 			carte avec l'id : idcard.
	 */
	@RequestMapping("/possession/{idcard}")
	public String byidcard(@PathVariable int idcard){
		return PossessionService.byidcard(idcard);
	}
	
	@RequestMapping("/test")
	public String test(){
		return "ok";
	}
	
	/**
	 * Cette fonction permet de récupérer toutes les cartes que possède
	 * l'utilisateur avec l'id : iduser.
	 * @param iduser
	 * @return [[allInfoCards] + prices] Les Informations de toutes les
	 * 			cartes que possède l'utilisateur avec l'id : iduser
	 * 			avec leur prix en plus.
	 */
	@RequestMapping("/possession/user/{iduser}")
	public String byiduser(@PathVariable int iduser) {
		return PossessionService.byiduser(iduser);
	}
	
	
	/**
	 * 
	 * @param iduser
	 * @param idcard
	 * @return true si l'iduser a la carte dans la BD 
	 */
	@RequestMapping("/havecard/{iduser}/{idcard}")
	public String haveCard(@PathVariable int iduser,@PathVariable int idcard) {
		return PossessionService.haveCard(iduser,idcard);
	}
	
	/**
	 * 
	 * @param idcard
	 * @return energy de la carte
	 */
	@RequestMapping("/haveenergy/{idcard}")
	public String haveEnergy(@PathVariable int idcard) {
		return PossessionService.haveEnergy(idcard);
	}
	
	
	
	/**
	 * Cette fonction permet de récupérer toutes les cartes que possède
	 * l'utilisateur avec l'id : iduser.
	 * @param iduser
	 * @return [[allInfoCards] + [allidusers] + prices] Les Informations
	 * 			de toutes les cartes que possède l'utilisateur avec 
	 * 			l'id : iduser avec l'id de leurs propriétaire //////////////(à voir + nom)
	 * 			ainsi que leur prix en plus.
	 */
	@RequestMapping("/onMarket/{iduser}")
	public String onMarket(@PathVariable int iduser) {
		return PossessionService.onMarket(iduser);
	}
	
	/**
	 * Cette fonction va changer le prix d'une carte dans la base
	 * de donnée possbd.
	 * @param iduser
	 * @param idcard
	 * @param price
	 * @return true si tout s'est réalisée jusqu'au bout, sinon false.
	 */
	@RequestMapping("/possession/setPrice/{iduser}/{idcard}/{price}")
	public String setPrice(@PathVariable int iduser, @PathVariable int idcard,
						 @PathVariable int price) {
		return PossessionService.setPrice(iduser, idcard, price);
	}
	
	/**
	 * Cette fonction va faire appel au MicroService User afin de savoir
	 * si l'utilisateur à assez d'argent, si c'est bon alors il va changer
	 * l'id de la carte dans la base de donnée possbd pour changer
	 * l'utilisateur puis demander au MS User de faire le virement.
	 * @param iduser
	 * @param iduserCard
	 * @param idcard
	 * @param price
	 * @return true si la transaction s'est réalisée jusqu'au bout, sinon false.
	 */
	/*
	@RequestMapping("/possession/buyCard/{iduser}/{iduserCard}/{idcard}/{price}")
	public void buyCard(@PathVariable int iduser, @PathVariable int iduserCard,
						@PathVariable int idcard, @PathVariable int price) {
		PossessionService.buyCard(iduser, iduserCard, idcard, price);
	}*/
	
	
}
