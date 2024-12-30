package com.ty.empapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ty.empapp.entity.Employee;
import com.ty.empapp.repo.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepository;
	
	public EmpService(EmpRepository empRepository) {
		this.empRepository=empRepository;
	}

	public String save(Employee employee) {
		Optional<Employee> opt = empRepository.findByEmail(employee.getEmail());
		
		if (opt.isPresent()) {
			return "Employee with "+employee.getEmail()+" is already registered";
		} else {
			Employee save = empRepository.save(employee);
			return "Employee is register successfully with EmployeeID : "+save.getEid();
		}
		
	}
}
