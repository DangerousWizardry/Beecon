/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.helpers;

/**
 *
 * @author Admin
 */
public class PositionPostDTO {
	private String addresseMacDispositif;
	private String addresseMacBalise;
	private long timestamp;
	private float attenuation;

	public PositionPostDTO(){
		super();
	}
	public PositionPostDTO(String addresseMacDispositif, String addresseMacBalise, long timestamp, float attenuation) {
		this.addresseMacDispositif = addresseMacDispositif;
		this.addresseMacBalise = addresseMacBalise;
		this.timestamp = timestamp;
		this.attenuation = attenuation;
	}

	public String getAddresseMacDispositif() {
		return addresseMacDispositif;
	}

	public void setAddresseMacDispositif(String addresseMacDispositif) {
		this.addresseMacDispositif = addresseMacDispositif;
	}

	public String getAddresseMacBalise() {
		return addresseMacBalise;
	}

	public void setAddresseMacBalise(String addresseMacBalise) {
		this.addresseMacBalise = addresseMacBalise;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public float getAttenuation() {
		return attenuation;
	}

	public void setAttenuation(float attenuation) {
		this.attenuation = attenuation;
	}
	
}
