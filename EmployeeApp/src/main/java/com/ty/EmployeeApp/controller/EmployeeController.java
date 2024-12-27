package com.ty.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.EmployeeApp.dto.EmployeeRequest;
import com.ty.EmployeeApp.dto.EmployeeResponse;
import com.ty.EmployeeApp.responsestruct.ResponseStructure;
import com.ty.EmployeeApp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		return employeeService.saveEmp(employeeRequest);
	}
	
	@PostMapping("/saves")
	public ResponseEntity<String> saveEmp(@RequestBody EmployeeRequest employeeRequest) {
		return employeeService.saveEm(employeeRequest);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> getEmployee(@RequestParam Integer eid) {
		return employeeService.getEmp(eid);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> getEmp() {
		
		EmployeeRequest em=null;
		em.getEmail();
		
		return ResponseEntity.ok("Successfull");
	}
}
