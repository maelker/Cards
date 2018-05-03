package cards.card.controller;

import org.springframework.data.repository.CrudRepository;

import cards.card.model.Family;

public interface FamilyRepository extends CrudRepository<Family, String>  {
	
	
	public Family findOne(String name);
	
	

}
