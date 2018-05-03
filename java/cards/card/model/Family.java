package cards.card.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Family {
	@Id
	private String name;
	private String strength;
	private String weakness;
	
	


	public  Family(String name,String strength,String weakness) {
		this.name=name;
		this.strength=strength;
		this.weakness=weakness;
	}
	public Family()
	{
		this("", "", "");
	}

	public String getName() {
		return name;
	}


	public String getStrength() {
		return strength;
	}


	public String getWeakness() {
		return weakness;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setStrength(String strength) {
		this.strength = strength;
	}


	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	
}
