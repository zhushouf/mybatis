package com.huaweisoft.training.dto;

import java.util.Date;

import com.huaweisoft.training.entity.Employee;

public class EmployeeExt extends Employee{
    
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}