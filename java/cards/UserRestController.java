package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.springboot.user.model.User;

//On pr�cise que cette classe est un controleur rest. Spring va automatiquement garder la liste de ses
//methodes anot�es par @RequestMapping ainsi que les URL qu'elles pointent pour les �x�cuter si l'url
//demand�e correspond
@RestController
public class UserRestController {
	
	// On d�l�gue � Spring la gestion de cet attribut, notament sa construction ainsi que la gestion de
    // ses propres injections
	@Autowired
	private UserService UserService;
	
	// L'anotation @RequestMapping permet d'indiquer quelle url devra �tre demand�e pour que l'on �x�cute
    // cette m�thode
	@RequestMapping("/test")
	private int test() {
		return 2+4;

	}
	@RequestMapping("/users")
	private List<User> getAllCourses() {
		return UserService.getAllUsers();

	}
	
	//l'annotation est utilis�e pour mapper les requ�tes Web aux m�thodes Spring Controller.
	@RequestMapping("/users/{id}")
	private User getUser(@PathVariable String id) {
		return UserService.getUser(id);

	}
	// On ajoute � @RequestMapping que l'url de la requ�te doit �tre /users et on pr�cise qu'elle doit
    // �tre de type post
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		UserService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		user.setId(Integer.valueOf(id));
		UserService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		UserService.deleteUser(id);
	}
	
	/*@RequestMapping("/users/name/{name}")
	private List<User> getAllCourses(@PathVariable String name) {
		return UserService.getUserByName(name);
	}*/
	//Cette m�thode permet de savoir si le solde est suffisant ou pas
	@RequestMapping("/users/{id}/{solde}")
	public Boolean soldeSuffisant(@PathVariable String id, @PathVariable int solde) {
		User user=UserService.getUser(id); 
		Boolean retour=False;
				if (user.getsolde()>=solde) {
					retour=True;
				}
		return retour; 
	}
	// cette m�thode permet d'affirmer si l'utilisateur existe dans la base ou pas
	@RequestMapping("users/{id}/{id}")
	public Boolean findUser(@PathVariable String id) {
		Boolean retour=False;
		try {
			User user=UserService.getUser(id); 
			if (!(user.equals(null))) {
				retour=True;
			}}catch (Exception e) {
				retour=True;
			}
		return retour;
	}
	// Cette m�thode permet de mettre � jour le solde de l'utilisateur
	@RequestMapping("users/{id}/{info}")
	public void MiseAJourSolde(@Pathvariable String id, @Pathvariable String info){
		User user=UserService.getUser(id); 
		int NewSolde=user.getsolde();
		int valeur=100; // prix d'une carte pour tester
		if (info.equals('1')){ // 1: achat
			solde-=prix;
			user.setsolde(solde);
		}
		else if (boolean.equals('0')){ // O: vente
			solde+=prix;
			user.setsolde(solde);
		}		
			
	}
	// Cette m�thode permet de faire un virement entre deux compte d'utilisateur
	@RequestMapping("users/{id1}/{id2}/{montant}")
	public void VirementMontant(@Pathvariable String id1,@Pathvariable String id1, @Pathvariable int montant,){
		Boolean retour=False;
		//les utilisateurs qui correspondent � id1 et id2
		User user1=UserService.getUser(id1);
		User user2=UserService.getUser(id2); 
		// on recup�re leurs soldes
		int NewSolde1=user1.getsolde();
		int NewSolde2=user2.getsolde();
		// on effectue le virement
		NewSolde1-=montant;
		NewSolde2+=montant;
		// on met la nouvelle valeur de solde;
		user1.setsolde(NewSolde1);
		user2.setsolde(NewSolde2);
		if ((NewSolde1==user1.getsolde())&&(NewSolde2==user2.getsolde())){
			retour=True;
		}
		return retour;
	}

}
