/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.BeaconDAO;
import isis.beecon.dao.DispositifDAO;
import isis.beecon.dao.PositionDAO;
import isis.beecon.helpers.PositionPostDTO;
import isis.beecon.models.Beacon;
import isis.beecon.models.Dispositif;
import isis.beecon.models.Position;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victoria
 */
@RestController 
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    PositionDAO positionDao;
	
	@Autowired
    DispositifDAO dispositifDAO;
	
	@Autowired
    BeaconDAO beaconDAO;
    
    @GetMapping(value="",produces = "application/json")
    public @ResponseBody List<Position> listAllPositions(){
        return positionDao.findAll();
    }
	
	@PostMapping(value = "", consumes = "application/json")
	public void postNewDispositif(@RequestBody PositionPostDTO[] listePositionDTO){
		for(PositionPostDTO positionDTO : listePositionDTO){
			Beacon b = beaconDAO.findByAddMac(positionDTO.getAddresseMacBalise());
			System.out.println(b);
			if(b!=null){
				Dispositif d = dispositifDAO.findByEntityMacAddress(positionDTO.getAddresseMacDispositif());
				System.out.println(d);
				Position p;
				if(d==null){
					d = new Dispositif("unknown entity", "", positionDTO.getAddresseMacDispositif(), false);
					dispositifDAO.save(d);
					p = new Position(new Date(positionDTO.getTimestamp()), positionDTO.getAttenuation(), b, d);
				}
				else{
					p = new Position(new Date(positionDTO.getTimestamp()), positionDTO.getAttenuation(), b, d);
				}
				positionDao.save(p);
			}
		}
	}
}
