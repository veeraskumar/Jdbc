package com.rvk.project.FetchType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aadhar {
	@Id
	private int aadharId;
	private int aadharNo;

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public int getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}

}
