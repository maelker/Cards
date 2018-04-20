package cards.possession.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PossessionIdentity implements Serializable {

	@NotNull
	private Integer idcard;
	
	@NotNull
	private Integer iduser;
	
	public PossessionIdentity()
	{
		
	}

	public PossessionIdentity(@NotNull Integer idcard, @NotNull Integer iduser) {
		super();
		this.idcard = idcard;
		this.iduser = iduser;
	}

	public Integer getidcard() {
		return idcard;
	}

	public void setidcard(Integer idcard) {
		this.idcard = idcard;
	}

	public Integer getiduser() {
		return iduser;
	}

	public void setiduser(Integer iduser) {
		this.iduser = iduser;
	}
}
