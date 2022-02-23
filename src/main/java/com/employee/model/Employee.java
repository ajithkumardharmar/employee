package com.employee.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int empCode;
	private String empName;
	private String empEmail;
	private String address1;
	private String address2;
	private String empCity;
	private String empState;
	private LocalDate dateOfBirth;
	private LocalDate joiningDate;
	private LocalDate joiningDatefrom;
	private LocalDate joiningDateTo;

	public LocalDate getJoiningDatefrom() {
		return joiningDatefrom;
	}

	public void setJoiningDatefrom(LocalDate joiningDatefrom) {
		this.joiningDatefrom = joiningDatefrom;
	}

	public LocalDate getJoiningDateTo() {
		return joiningDateTo;
	}

	public void setJoiningDateTo(LocalDate joiningDateTo) {
		this.joiningDateTo = joiningDateTo;
	}

	public Employee(int empCode, String empName, String empEmail, String empCity, String empState) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empCity = empCity;
		this.empState = empState;
	}

	public Employee(int empCode, String empCity, String empState, LocalDate joiningDatefrom, LocalDate joiningDateTo) {
		super();
		this.empCode = empCode;
		this.empCity = empCity;
		this.empState = empState;
		this.joiningDatefrom = joiningDatefrom;
		this.joiningDateTo = joiningDateTo;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee(int empCode, String empName, String empEmail, String address1, String address2, String empCity,
			String empState, LocalDate dateOfBirth, LocalDate joiningDate) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empEmail = empEmail;
		this.address1 = address1;
		this.address2 = address2;
		this.empCity = empCity;
		this.empState = empState;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
	}

	public Employee() {
		super();

	}

}