/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.SalleDAO;
import isis.beecon.models.Salle;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marie
 */

@RestController
@RequestMapping(value = "/salle")
public class SalleController {

    @Autowired
    SalleDAO salleDAO;

    @GetMapping("/")
    public List<Salle> listAllSalle() {
        return salleDAO.findAll();
    }
    
    public Salle getUserById(int id){
        return salleDAO.getOne((long)id);
    }
    
    public void DesSalles(){
    Salle Salle1 = new Salle();
    Salle Salle2 = new Salle();
}
   
}
