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
import java.util.List;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
					p.getBeacon();
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
		return dispositifs;
	}
	@CrossOrigin(origins = "*")
	@PatchMapping("/{id}")
	@ResponseBody
	public String patchArticle(@PathVariable("id") Long id,@RequestBody Dispositif patch) {
		Dispositif disp = dispositifDAO.findById(id).get();
		if (patch.getEntityDisplayName() != null) {
			disp.setEntityDisplayName(patch.getEntityDisplayName());
			disp.setEntityRegistered(true);
			dispositifDAO.save(disp);
			return "1";
		}
		return "0";
	}
}