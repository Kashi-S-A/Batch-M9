package com.ty.empapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp_info")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	
	private String name;
	 
	@Column(unique = true)
	private String email;
	
	private Long phone;
	
	private String password;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
}
