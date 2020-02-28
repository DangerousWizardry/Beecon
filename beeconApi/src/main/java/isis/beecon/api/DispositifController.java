/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.DispositifDAO;
import isis.beecon.models.Dispositif;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		return dispositifDAO.findByPosition_TimestampAfter(new Date(Long.decode(time)));
	}
	@RequestMapping(value = "")
    @ResponseBody
	public List<Dispositif> getAllDispositif(){
		return dispositifDAO.findAll();
	}
}
