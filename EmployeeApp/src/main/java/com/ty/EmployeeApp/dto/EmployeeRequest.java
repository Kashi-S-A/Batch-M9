package com.ty.EmployeeApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

	private String name;
	
	private String email;
	
	private Double salary;
}
