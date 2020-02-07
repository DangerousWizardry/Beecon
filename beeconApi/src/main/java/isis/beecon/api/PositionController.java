/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.PositionDAO;
import isis.beecon.models.Position;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author victoria
 */
@Controller
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    PositionDAO positionDao;
    
    @GetMapping("/")
    public List<Position> listAllPositions(){
        return positionDao.findAll();
    }
    
}
