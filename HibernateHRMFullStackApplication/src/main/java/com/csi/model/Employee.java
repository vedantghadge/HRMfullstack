package com.csi.model;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.event.PrintJobAttributeEvent;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int empId;
	
	private String empName;
	
	private String empAddress;
	
	@Column(unique = true)
	private long empContactNumber;
	
	private double empSalary;
	
	private String empGender;
	
	private int empAge;
	@Column(unique = true)
	private long empUID;
	
	@Column(unique = true)
	private String empPanCardNumber;
	
	@Temporal(TemporalType.DATE)
	private Date empDOB;
	@Column(unique = true)
	private String empEmailId;
	
	private String empPassword;
	
public Employee() {
	// TODO Auto-generated constructor stub
}

public Employee(String empName, String empAddress, long empContactNumber, double empSalary, String empGender,
		int empAge, long empUID, String empPanCardNumber, Date empDOB, String empEmailId, String empPassword) {
	super();
	this.empName = empName;
	this.empAddress = empAddress;
	this.empContactNumber = empContactNumber;
	this.empSalary = empSalary;
	this.empGender = empGender;
	this.empAge = empAge;
	this.empUID = empUID;
	this.empPanCardNumber = empPanCardNumber;
	this.empDOB = empDOB;
	this.empEmailId = empEmailId;
	this.empPassword = empPassword;
}

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmpAddress() {
	return empAddress;
}

public void setEmpAddress(String empAddress) {
	this.empAddress = empAddress;
}

public long getEmpContactNumber() {
	return empContactNumber;
}

public void setEmpContactNumber(long empContactNumber) {
	this.empContactNumber = empContactNumber;
}

public double getEmpSalary() {
	return empSalary;
}

public void setEmpSalary(double empSalary) {
	this.empSalary = empSalary;
}

public String getEmpGender() {
	return empGender;
}

public void setEmpGender(String empGender) {
	this.empGender = empGender;
}

public int getEmpAge() {
	return empAge;
}

public void setEmpAge(int empAge) {
	this.empAge = empAge;
}

public long getEmpUID() {
	return empUID;
}

public void setEmpUID(long empUID) {
	this.empUID = empUID;
}

public String getEmpPanCardNumber() {
	return empPanCardNumber;
}

public void setEmpPanCardNumber(String empPanCardNumber) {
	this.empPanCardNumber = empPanCardNumber;
}

public Date getEmpDOB() {
	return empDOB;
}

public void setEmpDOB(Date empDOB) {
	this.empDOB = empDOB;
}

public String getEmpEmailId() {
	return empEmailId;
}

public void setEmpEmailId(String empEmailId) {
	this.empEmailId = empEmailId;
}

public String getEmpPassword() {
	return empPassword;
}

public void setEmpPassword(String empPassword) {
	this.empPassword = empPassword;
}

@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empContactNumber="
			+ empContactNumber + ", empSalary=" + empSalary + ", empGender=" + empGender + ", empAge=" + empAge
			+ ", empUID=" + empUID + ", empPanCardNumber=" + empPanCardNumber + ", empDOB=" + empDOB + ", empEmailId="
			+ empEmailId + ", empPassword=" + empPassword + "]";
}

}
