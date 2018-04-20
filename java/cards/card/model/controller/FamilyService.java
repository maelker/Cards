package cards.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cards.card.model.Family;

@Service
public class FamilyService {
	
	@Autowired
	private FamilyRepository familyRepository;
	
	public Family getFamily(String family) {
		return familyRepository.findOne(family);
	}
}
