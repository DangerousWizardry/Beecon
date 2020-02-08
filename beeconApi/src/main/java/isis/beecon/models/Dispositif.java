/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Admin
 */
@Entity
public class Dispositif implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int entityId;
	private String entityDisplayName;
	private String entityFullName;
	private String entityMacAddress;
	private boolean entityRegistered;
        
	@OneToMany
    private List<Position> position;

	public Dispositif(int entityId, String entityDisplayName, String entityFullName, String entityMacAddress, boolean entityRegistered) {
        this.entityId = entityId;
		this.entityDisplayName = entityDisplayName;
		this.entityFullName = entityFullName;
		this.entityMacAddress = entityMacAddress;
		this.entityRegistered = entityRegistered;
	}

	public Dispositif(){}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public String getEntityDisplayName() {
		return entityDisplayName;
	}

	public void setEntityDisplayName(String entityDisplayName) {
		this.entityDisplayName = entityDisplayName;
	}

	public String getEntityFullName() {
		return entityFullName;
	}

	public void setEntityFullName(String entityFullName) {
		this.entityFullName = entityFullName;
	}

	public String getEntityMacAddress() {
		return entityMacAddress;
	}

	public void setEntityMacAddress(String entityMacAddress) {
		this.entityMacAddress = entityMacAddress;
	}

	public boolean isEntityRegistered() {
		return entityRegistered;
	}

	public void setEntityRegistered(boolean entityRegistered) {
		this.entityRegistered = entityRegistered;
	}

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}




}
