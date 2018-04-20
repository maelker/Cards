package cards.possession.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cards.possession.model.Possession;
import cards.possession.model.PossessionIdentity;

public interface PossessionRepository extends CrudRepository<Possession, PossessionIdentity>  {

	@Query(value="p.idcard "
			+ "	FROM possession p "
			+ "WHERE p.iduser==paramiduser", nativeQuery=true)
    public List<Integer> findCards(@Param("paramiduser") Integer iduser);
	
	@Query(value="p.price "
			+ "FROM possession p "
			+ "WHERE p.iduser==paramiduser "
			+ "		AND p.idcard==paramidcard ", nativeQuery=true)
    public List<Integer> findPrice(@Param("paramiduser") Integer iduser,
    							   @Param("paramidcard") Integer idcard);
	
	@Query(value="DISTINCT p.idcard, p.iduser "
			+ "FROM possession p "
			+ "WHERE p.iduser NOT IN ( "
			+ "		SELECT p1.iduser "
			+ "		FROM possession p1 "
			+ "		WHERE p1.iduser == paramiduser "
			+ "			OR p1.price == -1); ", nativeQuery=true)
    public List<PossessionIdentity> findonmarket(@Param("paramiduser") Integer iduser);
	
	@Query(value="UPDATE possession p "
			+ "SET p.price=paramprice "
			+ "WHERE p.iduser == paramiduser "
			+ "		AND p.idcard==paramidcard ", nativeQuery=true)
    public void setPrice(@Param("paramiduser") Integer iduser,
    					 @Param("paramidcard") Integer idcard,
    					 @Param("paramprice") Integer price);
	
	@Query(value="UPDATE possession p "
			+ "SET p.iduser = paramiduser "
			+ "WHERE p.iduser == paramidusercard "
			+ "		AND p.idcard == idcard")
	public void changeUserOfCard(@Param("paramidcard") Integer idcard,
								 @Param("paramidusercard") Integer idusercard,
								 @Param("paramiduser") Integer iduser);
	
	
}
