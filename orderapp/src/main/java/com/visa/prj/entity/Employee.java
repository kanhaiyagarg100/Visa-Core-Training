package com.visa.prj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String email;
	
	private String cell;

	public Employee(String email, String cell) {
		this.email = email;
		this.cell = cell;
	}

	public Employee() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
	
	
}
