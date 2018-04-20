package cards.possession.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Possession {

	@EmbeddedId
	/**
	 * Appel de l'identity d'une possession qui possède 
	 * un idcard et un iduser.
	 */
	private PossessionIdentity possessionIdentity;
	
	public PossessionIdentity getPossessionIdentity() {
		return possessionIdentity;
	}

	public void setPossessionIdentity(PossessionIdentity possessionIdentity) {
		this.possessionIdentity = possessionIdentity;
	}

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
	 * @param idcard
	 * @param iduser
	 * @param price
	 * @param energyCard
	 * @param lastUsed
	 */
	public Possession(@NotNull Integer idcard, @NotNull Integer iduser, @NotNull Integer price, @NotNull Integer energyCard, @NotNull Integer lastUsed)
	{
		super();
		this.possessionIdentity = new PossessionIdentity(idcard, iduser);
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
