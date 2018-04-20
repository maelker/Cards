/**
 * 
 */
package cards.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cards.room.model.Room;
import cards.room.model.RoomRepository;

/**
 * @author Martin
 * 
 * Controleur du microservice de Room
 *
 */
@Service
public class RoomService
{
	@Autowired
	private RoomRepository roomRepository;
	
	/**
	 * Retourne la room hébergée par hote
	 * 
	 * @param idHote
	 * @return
	 */
	public Room getRoom(int idHote)
	{
		return roomRepository.findOne(idHote);
	}
	
	/**
	 * Ce service permet de tester si un des joueurs a ses points de vie en dessous de 0
	 * 
	 * Si c'est le cas, met - à la place de l'id de l'user
	 * Si l'id de l'autre joueur est déjà à -1, on supprime la room de la base
	 * 
	 * Cette fonction permet de garder la room dans la base tant que les deux utilisateurs n'ont pas été informé
	 * 
	 * @param idHote
	 * @return
	 */
	public boolean isRoomEnded(int idHote, int idUser)
	{
		return false;
	}

	/**
	 * Persiste une room dans la base de donnée
	 * 
	 * @param room la room à persister
	 */
	public void addRoom(Room room)
	{
		roomRepository.save(room);
	}

	/**
	 * Récupère toutes les room non remplies
	 * 
	 * @return
	 */
	public List<Room> getList()
	{
		List<Room> rooms = roomRepository.findByIdClient(-1);
		
		return rooms;
	}
	
	public Room getRoomPlayed(int idUser)
	{
		return roomRepository.getRoomPlayed(idUser);
	}

	/**
	 * Met à jour la room
	 * @param room
	 */
	public void updateRoom(Room room)
	{		
		roomRepository.save(room);
	}
	
	/**
	 * Vérifie si la room est terminée ou non. Si c'est le cas, on place l'id de carte de l'user à -1
	 * pour indiquer que cet utilisateur a été informé de la fin
	 * @param room la room à mettre à jours
	 * @param idUser l'id du joueur
	 */
	public void verifyEnding(Room room, int idUser)
	{
		boolean userHost = room.getIdHote() == idUser;
		
		if(room.getPvClient() <= 0 || room.getPvHote() <= 0)
		{
			if(userHost && room.getIdCarteHote() != -1)
			{
				//On passe l'id de la carte de l'hote à -1
				room.setIdCarteHote(-1);
			}
			
			if(!userHost && room.getIdCarteClient() != -1)
			{
				//On passe l'id de la carte du client à -1
				room.setIdCarteClient(-1);
			}
			
			updateRoom(room);
		}
	}
}
