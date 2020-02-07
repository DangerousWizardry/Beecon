/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author victoria
 */

@Entity(name="User")
public class User {
    @Id
    private int id;
    private String emailAdress;
    private String name;
    private String surname;
    private String password;
    private boolean isSuperAdmin;
    private Date lastSeenAt;
    @OneToMany
    private Collection<Dispositif> dispositifCollection;

    public User(int id, String emailAdress, String name, String surname, String password, boolean isSuperAdmin) {
        this.id = id;
        this.emailAdress = emailAdress;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isSuperAdmin = isSuperAdmin;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }


    
    
}
