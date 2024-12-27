package com.ty.EmployeeApp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import com.ty.EmployeeApp.dao.EmployeeDao;
import com.ty.EmployeeApp.dto.EmployeeRequest;
import com.ty.EmployeeApp.dto.EmployeeResponse;
import com.ty.EmployeeApp.entity.Employee;
import com.ty.EmployeeApp.exception.EmpNotFound;
import com.ty.EmployeeApp.responsestruct.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseEntity<?> saveEmp(EmployeeRequest employeeRequest) {
		Optional<Employee> byEmail = employeeDao.getByEmail(employeeRequest.getEmail());

		if (byEmail.isPresent()) {
			ResponseStructure<String> rs = new ResponseStructure<>();
			rs.setMessage("Already registered");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
//			return "Employee with " + employeeRequest.getEmail() + " is already registered";
		} else {
			Employee employee = new Employee();

			BeanUtils.copyProperties(employeeRequest, employee);

			Employee saveEmp = employeeDao.saveEmp(employee);

			ResponseStructure<Integer> rs = new ResponseStructure<>();

			rs.setMessage("registered successfully");
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setData(saveEmp.getEid());
			return new ResponseEntity<ResponseStructure<Integer>>(rs, HttpStatus.OK);

//			return "Employee with " + saveEmp.getEid() + " is registered";
		}
	}
	
	public ResponseEntity<String> saveEm(EmployeeRequest employeeRequest) {
		Optional<Employee> byEmail = employeeDao.getByEmail(employeeRequest.getEmail());

		if (byEmail.isPresent()) {
			return ResponseEntity.badRequest().body("Already Registered");
		} else {
			Employee employee = new Employee();

			BeanUtils.copyProperties(employeeRequest, employee);

			Employee saveEmp = employeeDao.saveEmp(employee);
			
			return ResponseEntity.ok("Registered with eid : "+saveEmp.getEid());
		}
	}

	public ResponseEntity<ResponseStructure<EmployeeResponse>> getEmp(Integer eid) {
		Employee employee = employeeDao.getEmp(eid).orElseThrow(() -> new EmpNotFound("Employee Not found"));

		EmployeeResponse er = new EmployeeResponse();
		
		BeanUtils.copyProperties(employee, er);

		ResponseStructure<EmployeeResponse> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Employee fetched successfully");
		rs.setData(er);
		return new ResponseEntity<ResponseStructure<EmployeeResponse>>(rs, HttpStatus.OK);
	}
}
