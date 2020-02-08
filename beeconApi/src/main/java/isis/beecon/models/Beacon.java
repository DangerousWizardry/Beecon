package isis.beecon.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

@Entity(name = "Beacon")
public class Beacon {

    @javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    private String addMac;

    private int xEmplacement;
    private int yEmplacement;
	
    private String nom;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Salle salle;
    
    
    public Beacon(String addMac, int xEmplacement, int yEmplacement, String nom, Salle salle){
        this.salle= salle;
        this.addMac=addMac;
        this.xEmplacement=xEmplacement;
        this.yEmplacement=yEmplacement;
        this.nom=nom;
    }
    public Beacon(){
        
    }

	public int getId() {
		return id;
	}

	public String getAddMac() {
		return addMac;
	}

	public void setAddMac(String addMac) {
		this.addMac = addMac;
	}

	public int getxEmplacement() {
		return xEmplacement;
	}

	public void setxEmplacement(int xEmplacement) {
		this.xEmplacement = xEmplacement;
	}

	public int getyEmplacement() {
		return yEmplacement;
	}

	public void setyEmplacement(int yEmplacement) {
		this.yEmplacement = yEmplacement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
    

}
