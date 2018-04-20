package Controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.user.model.User;
//On cr�� une interface qui h�rite de CrudRepository pour avoir acc�s de mani�re transparente �
//toutes les m�thodes classiques d'acc�s et de modifications d'entit�s, comme la r�cup�ration de
//toutes les entit�s, la cr�ation etc.
public interface UserRepository extends CrudRepository<User, Integer> {
    //On ajoute une m�thode qui n'existe pas et qui permet de r�cup�rer un utilisateur par son nom
	public List<User> findByName(String name);

}