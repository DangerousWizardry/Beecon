/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

/**
 *
 * @author ruby
 */
@Entity(name = "Beacons")
public class Beacons {

    @javax.persistence.Id
    private int id;
    
    
    private long addMac;

    private long xEmplacement;
    private long yEmplacement;
    private String nom;
    
    @ManyToOne
    private Salle salle;
    @ManyToMany
    private Collection<Position> positionCollection;
    
    
    

    
    public Beacons(int id,long addMac, long xEmplacement, long yEmplacement, String nom, Salle salle,Collection<Position> positionCollection ){
        
        this.salle= salle;
        this.positionCollection=positionCollection;
        this.id=id;
        this.addMac=addMac;
        this.xEmplacement=xEmplacement;
        this.yEmplacement=yEmplacement;
        this.nom=nom;
    }
    public Beacons(){
        
    }
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the addMac
     */
    public long getAddMac() {
        return addMac;
    }

    /**
     * @param addMac the addMac to set
     */
    public void setAddMac(long addMac) {
        this.addMac = addMac;
    }

    /**
     * @return the xEmplacement
     */
    public long getxEmplacement() {
        return xEmplacement;
    }

    /**
     * @param xEmplacement the xEmplacement to set
     */
    public void setxEmplacement(long xEmplacement) {
        this.xEmplacement = xEmplacement;
    }

    /**
     * @return the yEmplacement
     */
    public long getyEmplacement() {
        return yEmplacement;
    }

    /**
     * @param yEmplacement the yEmplacement to set
     */
    public void setyEmplacement(long yEmplacement) {
        this.yEmplacement = yEmplacement;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    

}
