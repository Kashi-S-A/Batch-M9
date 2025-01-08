package com.tyss.counsellorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tyss.counsellorapp.entity.Counsellor;
import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.enums.Course;
import com.tyss.counsellorapp.enums.Status;
import com.tyss.counsellorapp.exception.CounsellorNotFound;
import com.tyss.counsellorapp.exception.EnquiryNotFoundException;
import com.tyss.counsellorapp.repository.CounsellorRepository;
import com.tyss.counsellorapp.repository.EnquiryRepository;

@Service
public class EnquiryService {

	private EnquiryRepository enquiryRepository;

	private CounsellorRepository counsellorRepository;

	public EnquiryService(EnquiryRepository enquiryRepository, CounsellorRepository counsellorRepository) {
		this.enquiryRepository = enquiryRepository;
		this.counsellorRepository = counsellorRepository;
	}

	public String addEnquiry(Integer cid, Enquiry enquiry) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not Found"));
		enquiry.setCounsellor(counsellor);
		enquiryRepository.save(enquiry);
		return "added";
	}

	public String updateStatus(Integer eid, Status status) {
		Enquiry enquiry = enquiryRepository.findById(eid)
				.orElseThrow(() -> new EnquiryNotFoundException("Enquiry Not Found"));
		enquiry.setStatus(status);
		Enquiry save = enquiryRepository.save(enquiry);
		return "status updated to " + save.getStatus();
	}

	public List<Enquiry> getByCourse(Course course) {
		return enquiryRepository.findByCourse(course);
	}
}
