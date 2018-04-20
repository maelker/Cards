/**
 * Représente une zone de duel entre deux joueurs/cartes
 */
package cards.room.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Martin
 *
 */
@Entity
public class Room {

	/**
	 * L'id de l'utilisateur qui héberge la room. C'est cet utilisateur qui va identifier la room
	 */
	@Id
	private int idHote;
	
	/**
	 * L'id du client qui a rejoint la room
	 */
	private int idClient;
	
	/**
	 * L'id du modele de la carte mise en jeu par l'hote
	 */
	private int idCarteHote;
	
	/**
	 * L'id du modele de la carte mise en jeu par le client
	 */
	private int idCarteClient;
	
	/**
	 * La mise imposée pour la partie
	 */
	private int bet;
	
	/**
	 * Le nom de la partie
	 */
	private String nom;
	
	/**
	 * Les PV restants de l'hote
	 */
	private int pvHote;
	
	/**
	 * Les PV restants du client
	 */
	private int pvClient;
	
	/**
	 * Le nombre de coups que l'hote a déjà infligé
	 */
	private int nbCoupsHote;
	
	/**
	 * Le nombre de coups que le client a déjà infligé
	 */
	private int nbCoupsClient;
	
	/**
	 * 
	 * @param idHote id de l'hote
	 * @param idClient id du client
	 * @param idCarteHote id du modele de carte de l'hote
	 * @param idCarteClient id du modele de carte du client
	 * @param bet mise de la partie
	 * @param nom nom de la partie
	 * @param pvHote pv initial de l'hote
	 * @param pvClient pv initial du client
	 */
	public Room(int idHote, int idClient, int idCarteHote, int idCarteClient, int bet, String nom, int pvHote,
			int pvClient, int nbCoupsHote, int nbCoupsClient)
	{
		super();
		this.idHote = idHote;
		this.idClient = idClient;
		this.idCarteHote = idCarteHote;
		this.idCarteClient = idCarteClient;
		this.bet = bet;
		this.nom = nom;
		this.pvHote = pvHote;
		this.pvClient = pvClient;
		this.nbCoupsHote = nbCoupsHote;
		this.nbCoupsHote = nbCoupsHote;
	}
	
	public Room(int idHote, int idCarte, int bet, String nom, int pvHote)
	{
		this(idHote, -1, idCarte, -1, bet, nom, pvHote, -1, 0, 0);
	}
	
	/**
	 * Constructeur vide
	 */
	public Room()
	{
		this(-1	, 0, 0, 0, 0, "", 0, 0, 0, 0);
	}

	/**
	 * @return the idHote
	 */
	public int getIdHote()
	{
		return idHote;
	}

	/**
	 * @param idHote the idHote to set
	 */
	public void setIdHote(int idHote)
	{
		this.idHote = idHote;
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient()
	{
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient)
	{
		this.idClient = idClient;
	}

	/**
	 * @return the idCarteHote
	 */
	public int getIdCarteHote()
	{
		return idCarteHote;
	}

	/**
	 * @param idCarteHote the idCarteHote to set
	 */
	public void setIdCarteHote(int idCarteHote)
	{
		this.idCarteHote = idCarteHote;
	}

	/**
	 * @return the idCarteClient
	 */
	public int getIdCarteClient()
	{
		return idCarteClient;
	}

	/**
	 * @param idCarteClient the idCarteClient to set
	 */
	public void setIdCarteClient(int idCarteClient)
	{
		this.idCarteClient = idCarteClient;
	}

	/**
	 * @return the mise
	 */
	public int getBet()
	{
		return bet;
	}

	/**
	 * @param bet the bet to set
	 */
	public void setBet(int bet)
	{
		this.bet = bet;
	}

	/**
	 * @return the nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * @return the pvHote
	 */
	public int getPvHote()
	{
		return pvHote;
	}

	/**
	 * @param pvHote the pvHote to set
	 */
	public void setPvHote(int pvHote)
	{
		this.pvHote = pvHote;
	}

	/**
	 * @return the pvClient
	 */
	public int getPvClient()
	{
		return pvClient;
	}

	/**
	 * @param pvClient the pvClient to set
	 */
	public void setPvClient(int pvClient)
	{
		this.pvClient = pvClient;
	}

	/**
	 * @return the nbCoupsHote
	 */
	public int getNbCoupsHote()
	{
		return nbCoupsHote;
	}

	/**
	 * @param nbCoupsHote the nbCoupsHote to set
	 */
	public void setNbCoupsHote(int nbCoupsHote)
	{
		this.nbCoupsHote = nbCoupsHote;
	}

	/**
	 * @return the nbCoupsClient
	 */
	public int getNbCoupsClient()
	{
		return nbCoupsClient;
	}

	/**
	 * @param nbCoupsClient the nbCoupsClient to set
	 */
	public void setNbCoupsClient(int nbCoupsClient)
	{
		this.nbCoupsClient = nbCoupsClient;
	}
}
