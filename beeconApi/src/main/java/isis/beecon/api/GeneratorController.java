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
import isis.beecon.models.Beacon;
import isis.beecon.models.Dispositif;
import isis.beecon.models.Position;
import isis.beecon.models.Salle;
import isis.beecon.models.ApplicationUser;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.LinkedList;
import java.util.function.Consumer;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marie
 */
@RestController
@RequestMapping(value = "/generator")
public class GeneratorController {

	@Autowired
	SalleDAO salleDAO;
	@Autowired
	UserDao userDAO;
	@Autowired
	PositionDAO positionDAO;
	@Autowired
	DispositifDAO dispositifDAO;
	@Autowired
	BeaconDAO beaconsDAO;

	@GetMapping("")
	public void generateur() {

		/*
		Generating dummy rooms
		 */
		Salle salle1 = new Salle("B007", 0, 10, 0, 10);
		Salle salle2 = new Salle("B106", 10, 20, 10, 20);

		salle1 = salleDAO.save(salle1);
		salle2 = salleDAO.save(salle2);

		/*
		Generating dummy beacon
		 */
		Beacon beacon1 = new Beacon("1234", 5, 5, "Beacon1", salle1);
		Beacon beacon2 = new Beacon("1234", 15, 15, "Beacon2", salle2);

		beacon1 = beaconsDAO.save(beacon1);
		beacon2 = beaconsDAO.save(beacon2);

		/*
		Generating dummy devices
		 */
		Dispositif dispositif1 = new Dispositif("smartphone1", "fullname1", "macadress", true);
		Dispositif dispositif2 = new Dispositif("smartphone2", "fullname2", "macadress", true);

		dispositif1 = dispositifDAO.save(dispositif1);
		dispositif2 = dispositifDAO.save(dispositif2);

		/*
		Generating dummy position
		 */
		Position position1 = new Position(new Date(), 25, beacon1, dispositif1);
		Position position2 = new Position(new Date(), 25, beacon2, dispositif2);

		positionDAO.save(position1);
		positionDAO.save(position2);

		/*
		Generating dummy user
		 */
		ApplicationUser user1 = new ApplicationUser("cent@gmail.com", "Cent", "X", "SuperPassword", false);
		ApplicationUser user2 = new ApplicationUser("deuxcent@gmail.com", "deuxcent", "X", "SuperPassword", false);

		userDAO.save(user1);
		userDAO.save(user2);

	}
	
	@GetMapping("/addRandomPosition")
	public void addRandomPosition(){
		dispositifDAO.findAll().forEach(new Consumer<Dispositif>() {
			@Override
			public void accept(Dispositif dispositif) {
				positionDAO.save(new Position(new Date(), 25, beaconsDAO.findAll().get(0), dispositif));
				System.out.println(".accept()");
			}
		});
	}
}
