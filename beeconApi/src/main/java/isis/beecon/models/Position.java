/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import isis.beecon.helpers.DateSerializer;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Position implements Serializable,Comparable{
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPosition;
	@JsonSerialize(using = DateSerializer.class)
    Date timestamp;
    float attenuation;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	Beacon beacon;
		
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ENTITY_ID")
	@JsonBackReference
	Dispositif dispositif;

	public Position(Date timestamp, float attenuation, Beacon beacon, Dispositif dispositif) {
		this.timestamp = timestamp;
		this.attenuation = attenuation;
		this.beacon = beacon;
		this.dispositif = dispositif;
	}
	public Position(){
		
	}

	public int getIdPosition() {
		return idPosition;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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

	@Override
	public int compareTo(Object o) {
		if(o.getClass()==this.getClass()){
			Position p = (Position) o;
			return this.idPosition - p.getIdPosition();
		}
		return 0;
	}
	

    
    
}
