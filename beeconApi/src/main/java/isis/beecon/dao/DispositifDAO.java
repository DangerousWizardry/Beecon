/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.dao;
import isis.beecon.models.Dispositif;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas
 */
@Repository
public interface DispositifDAO extends JpaRepository<Dispositif,Long>{
	
	public List<Dispositif> findByPosition_TimestampAfter(Date d,Sort t);
	public Dispositif findByEntityMacAddress(String macAddress);
	
}
