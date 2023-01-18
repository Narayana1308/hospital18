package com.ty.one_to_many_hospital_branch_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Hospital {
	@Id
	private int hospital_id;
	private String hospital_name;
	private String gst;
	private String hospital_address;
	private long hospital_phone;
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getHospital_address() {
		return hospital_address;
	}
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	public long getHospital_phone() {
		return hospital_phone;
	}
	public void setHospital_phone(long hospital_phone) {
		this.hospital_phone = hospital_phone;
	}
	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", gst=" + gst
				+ ", hospital_address=" + hospital_address + ", hospital_phone=" + hospital_phone + "]";
	}
 	
    

	
	

}
