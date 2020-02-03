/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.springframework.data.annotation.Id;

/**
 *
 * @author marie
 */
public class Salle {
    @Id
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
    
    public String getClef(){
        return this.NomSalle;
    }
}
