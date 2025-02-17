package com.rvk.project.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Aadhar {

	@Id
	private int aadharId;
	private long aadharNo;

	@OneToOne(mappedBy = "aadhar")
	private Person person;

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

}
