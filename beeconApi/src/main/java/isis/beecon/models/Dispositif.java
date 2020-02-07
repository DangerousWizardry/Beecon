/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private int deleteSignal;
	private long deleteLastSeen;
        
        @ManyToOne
        private Position position;

	public Dispositif(int entityId, String entityDisplayName, String entityFullName, String entityMacAddress, boolean entityRegistered, int deleteSignal, long deleteLastSeen) {
		this.entityId = entityId;
		this.entityDisplayName = entityDisplayName;
		this.entityFullName = entityFullName;
		this.entityMacAddress = entityMacAddress;
		this.entityRegistered = entityRegistered;
		this.deleteSignal = deleteSignal;
		this.deleteLastSeen = deleteLastSeen;
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

	public int getDeleteSignal() {
		return deleteSignal;
	}

	public void setDeleteSignal(int deleteSignal) {
		this.deleteSignal = deleteSignal;
	}

	public long getDeleteLastSeen() {
		return deleteLastSeen;
	}

	public void setDeleteLastSeen(long deleteLastSeen) {
		this.deleteLastSeen = deleteLastSeen;
	}
	
}
