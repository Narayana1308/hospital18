package com.ty.one_to_many_hospital_branch_dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	private int branch_id;
	private String branch_name;
	private String headOfBranch;
	private long branch_phone;
	@ManyToOne
	private Hospital hospital;
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getHeadOfBranch() {
		return headOfBranch;
	}
	public void setHeadOfBranch(String headOfBranch) {
		this.headOfBranch = headOfBranch;
	}
	public long getBranch_phone() {
		return branch_phone;
	}
	public void setBranch_phone(long branch_phone) {
		this.branch_phone = branch_phone;
	}
	
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_name=" + branch_name + ", headOfBranch=" + headOfBranch
				+ ", branch_phone=" + branch_phone + ", hospital=" + hospital + "]";
	}
	
	

}
