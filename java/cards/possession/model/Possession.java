package cards.possession.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Possession {

	@EmbeddedId
	/**
	 * Appel de l'identity d'une possession qui possède 
	 * un idCard et un idUser.
	 */
	private PossessionIdentity possessionIdentity;
	
	/**
	 * Corresspond au prix d'une carte.
	 */
	private Integer price;
	
	/**
	 * Corresspond à l'energie d'une carte
	 */
	private Integer energyCard;
	
	/**
	 * Corresspond à la date de dernière utilisation d'une carte.
	 */
	private Integer lastUsed;
	
	/**
	 * Constructeur nul d'une possession.
	 */
	public Possession()
	{
		this(0,0,0,0,0);
	}
	
	/**
	 * Constructeur d'une possession avec tous les paramètres dont
	 * il a besion.
	 * @param id_card
	 * @param id_user
	 * @param price
	 * @param energyCard
	 * @param lastUsed
	 */
	public Possession(@NotNull Integer id_card, @NotNull Integer id_user, @NotNull Integer price, @NotNull Integer energyCard, @NotNull Integer lastUsed)
	{
		super();
		this.possessionIdentity = new PossessionIdentity(id_card, id_user);
		this.setPrice(price);
		this.setEnergyCard(energyCard);
		this.setLastUsed(lastUsed);
	}

	/**
	 * @return the price of the card.
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param set the price of the card to price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the energyCard of the card.
	 */
	public Integer getEnergyCard() {
		return energyCard;
	}

	/**
	 * @param set the energyCard to energyCard
	 */
	public void setEnergyCard(Integer energyCard) {
		this.energyCard = energyCard;
	}

	/**
	 * @return the lastUsed date of the card.
	 */
	public Integer getLastUsed() {
		return lastUsed;
	}

	/**
	 * @param set the lastUsed date of the card to lastUsed.
	 */
	public void setLastUsed(Integer lastUsed) {
		this.lastUsed = lastUsed;
	}	
}