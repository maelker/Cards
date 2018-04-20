package Controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.user.model.User;
//On créé une interface qui hérite de CrudRepository pour avoir accès de manière transparente à
//toutes les méthodes classiques d'accès et de modifications d'entités, comme la récupération de
//toutes les entités, la création etc.
public interface UserRepository extends CrudRepository<User, Integer> {
    //On ajoute une méthode qui n'existe pas et qui permet de récupérer un utilisateur par son nom
	public List<User> findByName(String name);

}