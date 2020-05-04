/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Admin
 */
@Entity
public class Dispositif{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long entityId;
	private String entityDisplayName;
	private String entityFullName;
	private String entityMacAddress;
	private boolean entityRegistered;
        
	@OneToMany(fetch=FetchType.EAGER,mappedBy="dispositif")
	@JsonManagedReference
    private Set<Position> position;

	public Dispositif (String entityDisplayName, String entityFullName, String entityMacAddress, boolean entityRegistered) {
		this.entityDisplayName = entityDisplayName;
		this.entityFullName = entityFullName;
		this.entityMacAddress = entityMacAddress;
		this.entityRegistered = entityRegistered;
		this.position = new TreeSet<Position>();
	}

	public Dispositif(){}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
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

	public Set<Position> getPosition() {
		return position;
	}

	public void setPosition(TreeSet<Position> position) {
		this.position = position;
	}




}
