/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Position implements Serializable{
    
    @Id
    Date timeStamp;
    float attenuation;
	
	@OneToOne(fetch = FetchType.EAGER)
	Beacon beacon;
	
	@OneToOne(fetch = FetchType.EAGER)
	Dispositif dispositif;

	public Position(Date timeStamp, float attenuation, Beacon beacon, Dispositif dispositif) {
		this.timeStamp = timeStamp;
		this.attenuation = attenuation;
		this.beacon = beacon;
		this.dispositif = dispositif;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getAttenuation() {
		return attenuation;
	}

	public void setAttenuation(float attenuation) {
		this.attenuation = attenuation;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public Dispositif getDispositif() {
		return dispositif;
	}

	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}
	

    
    
}
