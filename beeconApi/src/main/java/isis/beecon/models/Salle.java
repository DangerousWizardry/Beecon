/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

/**
 *
 * @author marie
 */
@Entity(name = "Salle")
public class Salle {
    @javax.persistence.Id
    private String NomSalle;
    
    private double xDebut;
    private double xFin;
    private double yDebut;
    private double yFin;
    private Beacons MonBeacon;

    public Salle (String NomSalle, double xDebut, double xFin, double yDebut, double yFin, Beacons MonBeacon){
        this.NomSalle=NomSalle;
        this.xDebut=xDebut;
        this.xFin=xFin;
        this.yDebut=yDebut;
        this.yFin=yFin;
        this.MonBeacon=MonBeacon;
    }
    
    public Salle(){
        
    }
    public String getClef(){
        return this.NomSalle;
    }

    public Beacons getMonBeacon() {
        return MonBeacon;
    }

    public double getxDebut() {
        return xDebut;
    }

    public double getxFin() {
        return xFin;
    }

    public double getyDebut() {
        return yDebut;
    }

    public double getyFin() {
        return yFin;
    }
    
    public void setNomSalle(String NomSalle) {
        this.NomSalle = NomSalle;
    }

    public void setxDebut(double xDebut) {
        this.xDebut = xDebut;
    }

    public void setxFin(double xFin) {
        this.xFin = xFin;
    }

    public void setyDebut(double yDebut) {
        this.yDebut = yDebut;
    }

    public void setyFin(double yFin) {
        this.yFin = yFin;
    }
    
    
}


