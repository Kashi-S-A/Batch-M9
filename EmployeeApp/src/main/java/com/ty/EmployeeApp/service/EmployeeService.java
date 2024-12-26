package com.ty.EmployeeApp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.EmployeeApp.dao.EmployeeDao;
import com.ty.EmployeeApp.dto.EmployeeRequest;
import com.ty.EmployeeApp.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public String saveEmp(EmployeeRequest employeeRequest) {
		Optional<Employee> byEmail = employeeDao.getByEmail(employeeRequest.getEmail());
		
		if (byEmail.isPresent()) {
			return "Employee with "+employeeRequest.getEmail()+" is already registered";
		} else {
			Employee employee = new Employee();
			
			BeanUtils.copyProperties(employeeRequest,employee);
			
			Employee saveEmp = employeeDao.saveEmp(employee);
			
			return "Employee with "+saveEmp.getEid()+" is registered";
		}
	}
}
