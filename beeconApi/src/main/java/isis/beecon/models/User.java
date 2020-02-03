/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author victoria
 */

@Entity(name="User")
public class User {
    @Id
    private String emailAdress;
    private String name;
    private String surname;
    private String password;
    private boolean isSuperAdmin;
    private Date lastSeenAt;
    
}
