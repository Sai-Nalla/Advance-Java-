package com.nt.beans;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private int empid;
	private String empName;
	private float empsal;
	private float GrossSal;
	private float netSal;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpsal() {
		return empsal;
	}
	public void setEmpsal(float empsal) {
		this.empsal = empsal;
	}
	public float getGrossSal() {
		return GrossSal;
	}
	public void setGrossSal(float grossSal) {
		GrossSal = grossSal;
	}
	public float getNetSal() {
		return netSal;
	}
	public void setNetSal(float netSal) {
		this.netSal = netSal;
	}

}
