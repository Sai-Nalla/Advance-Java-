package com.nt.beans;

public class StudentBean {
	private int sno;
	private String name;
	private String addrs;
	private String avg;
	public StudentBean() {
	System.out.println("Student bean Constructor");
	}
	
	public int getSno() {
		System.out.println("StudentBean get Sn0");
		return sno;
	}
	public void setSno(int sno) {
		System.out.println("StudentBean set Sn0");
		this.sno = sno;
	}
	public String getName() {
		System.out.println("StudentBean get Sn0");
		return name;
	}
	public void setName(String name) {
		System.out.println("StudentBean set Sname");
		this.name = name;
	}
	public String getAddrs() {
		System.out.println("StudentBean get addrs");
		return addrs;
	}
	public void setAddrs(String addrs) {
		System.out.println("StudentBean set addrs");
		this.addrs = addrs;
	}
	public String getAvg() {
		System.out.println("StudentBean get avg");
		return avg;
	}
	public void setAvg(String avg) {
		System.out.println("StudentBean set Avg");
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "StudentBean [sno=" + sno + ", name=" + name + ", addrs=" + addrs + ", avg=" + avg + "]";
	}
	
	

}
