/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.SalleDAO;
import isis.beecon.dao.BeaconDAO;
import isis.beecon.dao.PositionDAO;
import isis.beecon.dao.DispositifDAO;
import isis.beecon.dao.UserDao;
import isis.beecon.models.Beacons;
import isis.beecon.models.Dispositif;
import isis.beecon.models.Position;
import isis.beecon.models.Salle;
import isis.beecon.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author marie
 */
@RestController
@RequestMapping(value = "/generator")
public class GeneratorController {
    @Autowired
    SalleDAO salleDAO;
    UserDao userDAO;
    PositionDAO positionDAO;
    DispositifDAO dispositifDAO;
    BeaconDAO beaconsDAO;
    
public void generateur(){
    
    LinkedList<Position> lesPositions = new LinkedList();
    LinkedList<Dispositif> lesDispositifs=new LinkedList();
        
    Salle salle1 = new Salle(0007,"B007",0,10,0,10);
    Salle salle2 = new Salle(106,"B106",10,20,10,20);
    
    User user1 = new User(100,"cent@gmail.com","Cent","X","SuperPassword",false,lesDispositifs);
    User user2 = new User(200,"deuxcent@gmail.com","deuxcent","X","SuperPassword",false,lesDispositifs);
    
    Position position1 = new Position(new Date(),50);
    Position position2 = new Position(new Date(),20);
    lesPositions.add(position1);
    lesPositions.add(position2);
    
    Dispositif dispositif1 = new Dispositif(11,"smartphone","fullname","macadress",true,1,2,position1);
    Dispositif dispositif2 = new Dispositif(34,"smartphone","fullname","macadress",true,3,4,position2);
    lesDispositifs.add(dispositif1);
    lesDispositifs.add(dispositif2);
    
    
    Beacons beacon1 = new Beacons(01, 1234, 5, 5, "Beacon1",salle1,lesPositions);
    Beacons beacon2 = new Beacons(02, 1234, 15, 15, "Beacon2",salle2,lesPositions);
}
    
    
}
