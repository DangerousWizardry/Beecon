/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.api;

import isis.beecon.dao.UserDao;
import isis.beecon.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author victoria
 */
@Controller
public class UserController {
    
    @Autowired
    UserDao userDao;
   
    public List<User> listAllUsers(){
        return userDao.findAll();
    }
    
    public User getUserById(int id){
        return userDao.getOne((long)id);
    }
}
