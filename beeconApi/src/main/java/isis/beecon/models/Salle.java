/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 *
 * @author marie
 */
@Entity(name = "Salle")
public class Salle {
    @javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int salleId;
    
    private String NomSalle;
    private double xDebut;
    private double xFin;
    private double yDebut;
    private double yFin;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
	private Beacon beacon;
	
    public Salle (String NomSalle, double xDebut, double xFin, double yDebut, double yFin){
        this.NomSalle=NomSalle;
        this.xDebut=xDebut;
        this.xFin=xFin;
        this.yDebut=yDebut;
        this.yFin=yFin;
    }
    
    public Salle(){
        
    }

	public int getSalleId() {
		return salleId;
	}

	public String getNomSalle() {
		return NomSalle;
	}

	public void setNomSalle(String NomSalle) {
		this.NomSalle = NomSalle;
	}

	public double getxDebut() {
		return xDebut;
	}

	public void setxDebut(double xDebut) {
		this.xDebut = xDebut;
	}

	public double getxFin() {
		return xFin;
	}

	public void setxFin(double xFin) {
		this.xFin = xFin;
	}

	public double getyDebut() {
		return yDebut;
	}

	public void setyDebut(double yDebut) {
		this.yDebut = yDebut;
	}

	public double getyFin() {
		return yFin;
	}

	public void setyFin(double yFin) {
		this.yFin = yFin;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}
	
}


