package com.cisco.prj.dto;

import java.util.Date;

public class ReportDTO {
	private int oid;
	private Date orderDate;
	private double total;
	private String email;
	private	String firstName;
	
	public ReportDTO() {
	}
	public ReportDTO(int oid, Date orderDate, double total, String email, String firstName) {
		this.oid = oid;
		this.orderDate = orderDate;
		this.total = total;
		this.email = email;
		this.firstName = firstName;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
