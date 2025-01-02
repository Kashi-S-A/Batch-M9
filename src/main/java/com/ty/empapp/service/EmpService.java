package com.ty.empapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ty.empapp.entity.Employee;
import com.ty.empapp.repo.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepository;

	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	public String save(Employee employee) {
		Optional<Employee> opt = empRepository.findByEmail(employee.getEmail());

		if (opt.isPresent()) {
			return "Employee with " + employee.getEmail() + " is already registered";
		} else {
			Employee save = empRepository.save(employee);
			return "Employee is register successfully with EmployeeID : " + save.getEid();
		}

	}

	public boolean login(String email, String password) {
		Optional<Employee> opt = empRepository.findByEmail(email);

		if (opt.isPresent()) {
			if (opt.get().getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public List<Employee> getAll() {
		return empRepository.findAll();
	}

	public Employee findById(Integer eid) {
		return empRepository.findById(eid).get();
	}
	
	public String update(Employee employee) {
		empRepository.save(employee);
		return "updated";
	}

	public String deleteByEid(Integer eid) {
		empRepository.deleteById(eid);
		return "Deleted";
	}
}
