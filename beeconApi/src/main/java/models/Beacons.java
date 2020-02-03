/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

/**
 *
 * @author ruby
 */
@Entity(name = "Beacons")
public class Beacons {

    @javax.persistence.Id
    private long addMac;

    private long xEmplacement;
    private long yEmplacement;
    private String nom;

    public long getId() {
        return addMac;
    }

    public long getAddMac() {
        return addMac;
    }

    public void setAddMac(long addMac) {
        this.addMac = addMac;
    }

}
