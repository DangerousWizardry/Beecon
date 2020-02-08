/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.BeaconDAO;
import java.util.List;
import isis.beecon.models.Beacon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ruby
 */
@RestController
@RequestMapping(value = "/beacons")
public class BeaconsController {
    @Autowired
    BeaconDAO beaconDAO;
    @GetMapping("/")
    public List<Beacon> listAllBeacons(){
        return beaconDAO.findAll();
    }
    
}
