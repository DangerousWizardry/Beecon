/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.DispositifDAO;
import isis.beecon.models.Dispositif;
import isis.beecon.models.Position;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ruby
 */
@RestController
@RequestMapping(value = "/dispositifs")
public class DispositifController {
    @Autowired
    DispositifDAO dispositifDAO;
	
    @RequestMapping(value = "",
            params = {"time"})
    @ResponseBody
	public List<Dispositif> getAllDispositifShort(@RequestParam String time){
		Sort sort = Sort.by("position_idPosition").ascending().and(Sort.by("entityId").ascending());
		List<Dispositif> dispositifs = dispositifDAO.findByPosition_TimestampAfter(new Date(Long.decode(time)),sort);
		System.out.println(dispositifs.size());
		dispositifs.forEach((d) ->{
			TreeSet hs = new TreeSet<Position>();
			Date requestedDate = new Date(Long.decode(time));
			d.getPosition().forEach((p)->{
				if(p.getTimestamp().after(requestedDate)){
					hs.add(p);
				}
			});
			d.setPosition(hs);
		});
		System.out.println(dispositifs.size());
		return dispositifs;
	}
	
	@RequestMapping(value = "")
    @ResponseBody
	public List<Dispositif> getAllDispositif(){
		List<Dispositif> dispositifs = dispositifDAO.findAll();
		dispositifs.forEach((d) ->{
			TreeSet hs = new TreeSet<Position>(d.getPosition());
			d.setPosition(hs);
		});
		return dispositifs;
	}
}
