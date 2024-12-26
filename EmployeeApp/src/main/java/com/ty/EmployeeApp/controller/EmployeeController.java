package com.ty.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.EmployeeApp.dto.EmployeeRequest;
import com.ty.EmployeeApp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public String saveEmp(@RequestBody EmployeeRequest employeeRequest) {
		
		return employeeService.saveEmp(employeeRequest);
	}
}
