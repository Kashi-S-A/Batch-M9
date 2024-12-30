package com.ty.empapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.empapp.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmail(String email);

}
