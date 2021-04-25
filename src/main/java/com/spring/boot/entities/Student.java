package com.spring.boot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private Integer studId;
	private String studName;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + "]";
	}

	public Student(Integer studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
