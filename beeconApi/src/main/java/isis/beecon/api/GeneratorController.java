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
import isis.beecon.models.User;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.LinkedList;
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

	@GetMapping("/")
	public void generateur() {

		/*
		Generating dummy rooms
		 */
		Salle salle1 = new Salle(0007, "B007", 0, 10, 0, 10);
		Salle salle2 = new Salle(106, "B106", 10, 20, 10, 20);

		salleDAO.save(salle1);
		salleDAO.save(salle2);

		/*
		Generating dummy beacon
		 */
		Beacon beacon1 = new Beacon(01, "1234", 5, 5, "Beacon1", salle1);
		Beacon beacon2 = new Beacon(02, "1234", 15, 15, "Beacon2", salle2);

		beaconsDAO.save(beacon1);
		beaconsDAO.save(beacon2);

		/*
		Generating dummy devices
		 */
		Dispositif dispositif1 = new Dispositif(11, "smartphone1", "fullname1", "macadress", true);
		Dispositif dispositif2 = new Dispositif(34, "smartphone2", "fullname2", "macadress", true);

		dispositifDAO.save(dispositif1);
		dispositifDAO.save(dispositif2);

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
		User user1 = new User(100, "cent@gmail.com", "Cent", "X", "SuperPassword", false);
		User user2 = new User(200, "deuxcent@gmail.com", "deuxcent", "X", "SuperPassword", false);

		userDAO.save(user1);
		userDAO.save(user2);

	}
}
