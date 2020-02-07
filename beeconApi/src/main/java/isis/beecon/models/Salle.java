/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 *
 * @author marie
 */
@Entity(name = "Salle")
public class Salle {
    @javax.persistence.Id
    private int salleId;
    
    private String NomSalle;
    private double xDebut;
    private double xFin;
    private double yDebut;
    private double yFin;

    public Salle (String NomSalle, double xDebut, double xFin, double yDebut, double yFin){
        this.NomSalle=NomSalle;
        this.xDebut=xDebut;
        this.xFin=xFin;
        this.yDebut=yDebut;
        this.yFin=yFin;
    }
    
    public Salle(){
        
    }
    
    public int getId(){
        return salleId;
    }
    public String getNomSalle(){
        return this.NomSalle;
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

    public int getSalleId() {
        return salleId;
    }

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }
    
    
}


