/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.dao;

import isis.beecon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author victoria
 */

@Repository
public interface daoUser extends JpaRepository<User, Long>{
}
