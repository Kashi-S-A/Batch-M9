package com.ty.EmployeeApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.EmployeeApp.entity.Employee;
import com.ty.EmployeeApp.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee saveEmp(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Optional<Employee> getEmp(Integer eid) {
		return employeeRepo.findById(eid);
	}
	
	public Optional<Employee> getByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	public void delete(Integer eid) {
		employeeRepo.deleteById(eid);
	}
}
