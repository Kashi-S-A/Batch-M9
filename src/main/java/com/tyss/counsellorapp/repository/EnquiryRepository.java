package com.tyss.counsellorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.enums.ClassMode;
import com.tyss.counsellorapp.enums.Course;
import com.tyss.counsellorapp.enums.Status;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	List<Enquiry> findByCourse(Course course);
	
	List<Enquiry> findByStatus(Status status);
	
	List<Enquiry> findByClassMode(ClassMode classMode);
	
}
