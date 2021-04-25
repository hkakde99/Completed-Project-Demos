package com.spring.boot.beans;

public class StudentBean {// model class of student called as bean
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

	public StudentBean(Integer studId, String studName) {
		super();
		this.studId = studId;
		this.studName = studName;
	}

	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
