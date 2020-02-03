/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author victoria
 */
public class User {
    @Id
    private String emailAdress;
    private String name;
    private String surname;
    private String password;
    private boolean isSuperAdmin;
    private Date lastSeenAt;
    
}
