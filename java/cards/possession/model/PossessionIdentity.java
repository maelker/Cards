package cards.possession.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PossessionIdentity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer id_card;
	
	@NotNull
	private Integer id_user;
	
	public PossessionIdentity()
	{
		
	}

	public PossessionIdentity(@NotNull Integer id_card, @NotNull Integer id_user) {
		super();
		this.id_card = id_card;
		this.id_user = id_user;
	}

	public Integer getId_card() {
		return id_card;
	}

	public void setId_card(Integer id_card) {
		this.id_card = id_card;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
}
