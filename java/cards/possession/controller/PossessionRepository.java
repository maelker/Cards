package cards.possession.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cards.possession.model.Possession;
import cards.possession.model.PossessionIdentity;

public interface PossessionRepository extends CrudRepository<Possession, PossessionIdentity>  {

	@Query(value="SELECT idcard FROM possession p WHERE p.iduser=:paramiduser", nativeQuery=true)
    public List<Integer> findCards(@Param("paramiduser") Integer iduser);

	@Query(value="SELECT idcard FROM possession p WHERE p.iduser=:paramiduser and p.idcard=:paramidcard", nativeQuery=true)
    public List<Integer> haveCard(@Param("paramiduser") Integer iduser,@Param("paramidcard") Integer idcard);
	
	@Query(value="SELECT energy_card FROM possession p WHERE p.idcard=:paramidcard", nativeQuery=true)
    public String haveEnergy(@Param("paramidcard") Integer idcard);
	
	@Query(value="SELECT p.price "
			+ "FROM possession p "
			+ "WHERE p.iduser=:paramiduser "
			+ "		AND p.idcard=:paramidcard ", nativeQuery=true)
    public List<Integer> findPrice(@Param("paramiduser") Integer iduser,@Param("paramidcard") Integer idcard);
	
	
	@Query(value="SELECT DISTINCT p.idcard, p.iduser FROM possession p WHERE p.iduser NOT IN ( SELECT iduser FROM possession p WHERE p.iduser =:paramiduser OR p.price = -1)", nativeQuery=true)
    public List<PossessionIdentity> findonmarket(@Param("paramiduser") Integer iduser);
	
	
	/*
	@Query(value="UPDATE possession p "
			+ "SET p.iduser =:paramiduser "
			+ "WHERE p.iduser =:paramidusercard "
			+ "		AND p.idcard =:paramidcard")
	public void changeUserOfCard(@Param("paramidcard") Integer idcard,
								 @Param("paramidusercard") Integer idusercard,
								 @Param("paramiduser") Integer iduser);*/
	
	
	
}
