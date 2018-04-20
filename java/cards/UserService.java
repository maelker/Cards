package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.springboot.user.model.User;


//On précise que cette classe est un composant qui représente un service 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
        //la méthode findAll retourne un iterable donc on doit le parcourir pour remplir une liste
        //C'est ensuite cette liste que l'on va retourner
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add); 
		return users;
	}

	public User getUser(String id) {
		return userRepository.findOne(Integer.valueOf(id));
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);

	}

	public void deleteUser(String id) {
		userRepository.delete(Integer.valueOf(id));
	}

	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}

}
