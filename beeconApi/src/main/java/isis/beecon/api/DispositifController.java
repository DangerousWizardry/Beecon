/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.DispositifDAO;
import isis.beecon.models.Dispositif;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
    @GetMapping("")
	public List<Dispositif> getAllDispositif(){
		return dispositifDAO.findAll();
	}
	@GetMapping("/randomize")
	public void randomize(){
		Random r = new Random();
		if(dispositifDAO.findAll().size()==0){
			for (int i = 0; i < 4; i++) {
				dispositifDAO.save(new Dispositif(i, "Doctor "+i, "M. X", String.valueOf(r.nextInt()), true, r.nextInt()%4 , System.currentTimeMillis(), Position Position);
			}
		}
		else{
			List<Dispositif> ds = dispositifDAO.findAll();
			ds.forEach( (d) -> {
				d.setDeleteLastSeen(System.currentTimeMillis());
				d.setDeleteSignal(r.nextInt()%4);
			});
		}
	}
	
	
    
}
