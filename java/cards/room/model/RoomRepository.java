package cards.room.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Integer>
{
	public List<Room> findByIdClient(int idClient);

	@Query(value="SELECT * FROM room as r WHERE r.id_hote = :paramIdUser OR r.id_client = :paramIdUser", nativeQuery=true)
	public Room getRoomPlayed(@Param("paramIdUser") int idUser);
}
