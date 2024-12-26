package com.ty.EmployeeApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.EmployeeApp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByEmail(String email);
}
