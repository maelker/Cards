/**
 * 
 */
package cards.room.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cards.card.model.Card;
import cards.possession.model.Possession;
import cards.room.model.Room;
import cards.room.service.RoomService;

/**
 * @author Martin
 * 
 * Controleur du microservice de Room
 *
 */
@RestController
public class RoomRestController
{
	@Autowired
	private RoomService roomService;
	
	private RestTemplate restTemplate;
	
	//Urls des autres microservices
	static final String POSSESSION_MICROSERVICE_ROOT = "http://localhost:8080/possessions";
	static final String CARTES_MICROSERVICE_ROOT = "http://localhost:8080/cartes";
	static final String USER_MICROSERVICE_ROOT = "http://localhost:8080/users";
			
	//Energie minimale pour qu'une carte soit mise en jeu
	static final int ENERGIE_MINIMALE = 10;
	
	public RoomRestController()
	{
		super();
		restTemplate = new RestTemplate();
	}
	
	/**
	 * Créé une nouvelle room
	 * 
	 * @param idUser l'id de l'utilisateur qui veut créér la room
	 * @param idCard l'id de la carte que l'utilisateur veut mettre en jeu
	 * @param bet la mise de l'utilisateur
	 * @param name le nom de la room
	 * @return  0 si la création s'est bien passée
	 * 			1 si l'utilisateur est déjà en jeu
	 * 			2 si l'utilisteur ne possède pas la carte
	 * 			3 si la carte n'a pas assez d'énergie
	 * 			4 si le solde est insufisant
	 * 			5 si le modèle de la carte n'existe pas
	 */
	@RequestMapping(method=RequestMethod.POST, value="/rooms")
	public int create(@RequestParam("idUser") int idUser, @RequestParam("idCard") int idCard, @RequestParam("bet") int bet, @RequestParam("name") String name)
	{		
		//Vérification que l'utilisateur n'est pas déjà en jeu
		if(roomService.getRoomPlayed(idUser) != null)
		{
			return 1;
		}
		
		//Vérification de la possession de la carte
		
		//TODO remplacer les lignes suivantes
		Possession cartePossedee = new Possession(idCard, idUser, 100, 250, 0);
		
		//PAR
		//String urlPossession = POSSESSION_MICROSERVICE_ROOT + "/" + String.valueOf(idUser) + "/" + String.valueOf(idCard);
		//Possession cartePossedee = restTemplate.getForObject(urlPossession , Possession.class);
		if(cartePossedee == null)
		{
			return 2;
		}
		
		//Vérification de l'énergie de la carte
		if(cartePossedee.getEnergyCard() < ENERGIE_MINIMALE)
		{
			return 3;
		}

		
		//Vérification du solde de l'hote
		//TODO remplacer les lignes suivantes
		boolean soldeSuffisant = true;
		
		//PAR
		//String urlPossession = USER_MICROSERVICE_ROOT + "/" + String.valueOf(idUser) + "/solde/" + String.valueOf(bet);
		//boolean soldeSuffisant = restTemplate.getForObject(urlPossession, Boolean.class);
		
		if(!soldeSuffisant)
		{
			return 4;
		}
		
		//Récupération du modèle de la carte
		//TODO remplacer les lignes suivantes
		Card carteModele = new Card();
		
		if(carteModele == null)
		{
			return 5;
		}
		
		//Création de la room dans la table
		Room room = new Room(idUser, idCard, bet, name, carteModele.getHp());
		
		roomService.addRoom(room);
		
		return 0;
	}
	
	/**
	 * Retourne la liste des room non complètes
	 * 
	 * Si l'utilisateur est déjà connecté à une autre room, détruit cette room et lui fait perdre sa mise si
	 * elle était complète
	 * @param idUser
	 * @return la liste des room non complètes
	 */
	@RequestMapping(method=RequestMethod.GET, value="/rooms")
	public List<Room> getList(@RequestParam("idUser") int idUser)
	{
		// Verification existence d'une partie en cours dont user est l'hote ou le client
		//Vérification que l'utilisateur n'est pas déjà en jeu
		if(roomService.getRoomPlayed(idUser) != null)
		{
			List<Room> retour = new ArrayList<Room>();
			retour.add(new Room());
			
			return retour;
		}
		
		// Récupération des rooms disponibles
		List<Room> rooms = roomService.getList();
		
		return rooms;
	}
	
	/**
	 * Ajoute l'utilisateur en tant que client à la room de l'hote
	 * 
	 * @param idHote l'utilisateur qui a lancé la partie
	 * @param idUser l'utilisateur qui veut rejoindre la partie
	 * @param idCard la carte que le client souhaite utiliser dans la partie
	 * @return 0 si la partie a bien été rejointe
	 * @return -1 si la partie n'est pas disponible
	 * @return -2 si l'utilisateur ne possède pas la carte
	 *
	 * @return n si l'utilisateur est déjà en partie, n étant l'id de la partie en question
	 */
	@RequestMapping(method=RequestMethod.POST, value="/rooms/join")
	public int join(@RequestParam("idHote") int idHote, @RequestParam("idUser") int idUser, @RequestParam("idCard") int idCard)
	{
		//On verifie que user n'est pas déjà dans une partie en cours. Si c'est le cas, on l'en supprime
		Room roomAlreadyPlayed = roomService.getRoomPlayed(idUser);

		
		if(roomAlreadyPlayed != null)
		{
			return roomAlreadyPlayed.getIdHote();
		}
		
		//On teste qu'une partie est bien hébergée par hote et qu'elle est vide
		Room room = roomService.getRoom(idHote);
		if(room == null || !(room.getIdClient() == -1 && room.getIdCarteClient() == -1))
		{
			return -1;
		}
		
		//On regarde que user possède bien la carte
		//TODO remplacer les lignes suivantes
		Possession cartePossedee = new Possession(idCard, idUser, 100, 250, 0);
		
		//PAR
		//String urlPossession = POSESSION_MICROSERVICE_ROOT + "/" + String.valueOf(idUser) + "/" + String.valueOf(idCard);
		//Possession cartePossedee = restTemplate.getForObject(urlPossession , Possession.class);
		if(cartePossedee == null)
		{
			return -2;
		}
		
		//On ajoute user et sa carte comme client
		room.setIdCarteClient(idCard);
		room.setIdClient(idUser);
		
		roomService.updateRoom(room);
		
		return 0;
	}
	
	/**
	 * Permet à un joueur, s'il le peut, d'attaquer
	 * 
	 * @param idHote
	 * @param idUser
	 * @return n la valeur de l'attaque, si l'attaque s'est bien déroulée
	 * @return -1 si la room n'existe pas
	 * @return -2 si le membre ne fait pas partie de la room
	 * @return -3 si ce n'est pas au tour du membre de jouer
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/rooms/{idHost}/attack/{idUser}")
	public int attack(@RequestParam("idHost") int idHote, @RequestParam("idUser") int idUser)
	{
		//On récupère la room
		Room room = roomService.getRoom(idHote);
		if(room == null)
		{
			return -1;
		}
		
		boolean userHost = idHote == idUser;
		
		//On teste si le joueur est dans la room
		if(room.getIdClient() != idUser && !userHost)
		{
			return -2;
		}
		
		int nbCoupsClient = room.getNbCoupsClient();
		int nbCoupsHote = room.getNbCoupsHote();
		
		//On teste si c'est bien au joueur de jouer
		if((userHost && nbCoupsClient < nbCoupsHote)  || (!userHost && nbCoupsHote < nbCoupsClient))
		{
			return -3;
		}
		
		//On demande l'attaque théorique d'une carte sur l'autre
		int idCarteAttaquant;
		int idCarteVictime;
		
		if(userHost)
		{
			idCarteAttaquant = room.getIdCarteHote();
			idCarteVictime = room.getIdCarteClient();
		} else {
			idCarteAttaquant = room.getIdCarteClient();
			idCarteVictime = room.getIdCarteHote();
		}
		
		//TODO remplacer les lignes suivantes
		int attaqueTheorique = 20;
		
		//PAR
//		String urlPossession = CARTES_MICROSERVICE_ROOT + "/" + String.valueOf(idCarteAttaquant) + "/" + String.valueOf(idCarteVictime);
//		int attaqueTheorique = restTemplate.getForObject(urlPossession , Integer.class);
		
		int attaqueReele = (int) Math.random() * attaqueTheorique;
		
		//On décrmente les pts de vie de l'attaqué
		if(userHost)
		{
			room.setPvClient(Math.min(0, room.getPvClient() - attaqueReele));
		}
		else
		{
			room.setPvHote(Math.min(0, room.getPvHote() - attaqueReele));
		}
		
		roomService.updateRoom(room);
		
		return attaqueReele;
	}
	
	/**
	 * Permet de conaitre l'état de la partie
	 * 
	 * Si la partie est finie, retire ce membre de la partie (met son id à -1)
	 * Si l'id de l'autre membre est à -1, supprime la partie
	 * 
	 * @param idHote
	 * @param idUser
	 * @return la partie
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/rooms/{idHost}/state/{idUser}")
	public Room getState(@RequestParam("idHote") int idHote, @RequestParam("idUser") int idUser)
	{
		//On regarde qu'une partie existe bien avec hote
		Room room = roomService.getRoom(idHote);
		if(room == null)
		{
			return null;
		}
		
		//On vérifie si la partie est terminée
		roomService.verifyEnding(room, idUser);
		
		//On retourne la partie
		return room;
	}
}
