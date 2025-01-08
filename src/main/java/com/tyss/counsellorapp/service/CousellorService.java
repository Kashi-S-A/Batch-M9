package com.tyss.counsellorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tyss.counsellorapp.dto.CounsellorRequest;
import com.tyss.counsellorapp.entity.Counsellor;
import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.exception.CounsellorNotFound;
import com.tyss.counsellorapp.repository.CounsellorRepository;

@Service
public class CousellorService {

	private CounsellorRepository counsellorRepository;

	public CousellorService(CounsellorRepository counsellorRepository) {
		this.counsellorRepository = counsellorRepository;
	}

	public boolean registerCounsellor(CounsellorRequest request) {
		Optional<Counsellor> opt = counsellorRepository.findByEmail(request.getEmail());

		if (opt.isPresent()) {
			return false;
		} else {
			Counsellor counsellor = new Counsellor();
			BeanUtils.copyProperties(request, counsellor);
			counsellorRepository.save(counsellor);
			return true;
		}

	}

	public boolean login(String email, String password) {
		Counsellor counsellor = counsellorRepository.findByEmail(email)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor is not register"));
		if (counsellor.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Counsellor updateCounsellor(Integer cid, CounsellorRequest counsellorRequest) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not found/Enter registered cid"));
		if (counsellorRequest.getName() != null)
			counsellor.setName(counsellorRequest.getName());
		if (counsellorRequest.getEmail() != null)
			counsellor.setEmail(counsellorRequest.getEmail());
		if (counsellorRequest.getPhone() != null)
			counsellor.setPhone(counsellorRequest.getPhone());
		if (counsellorRequest.getPassword() != null)
			counsellor.setPassword(counsellorRequest.getPassword());
		return counsellorRepository.save(counsellor);

	}

	public String updatePwd(Integer id, String password) {
		Counsellor counsellor = counsellorRepository.findById(id)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not found/Enter registered cid"));
		counsellor.setPassword(password);

		counsellorRepository.save(counsellor);

		return "Password is updated";
	}
	
	public String deleteCounsellor(Integer cid) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not found/Enter registered cid"));
		counsellorRepository.delete(counsellor);
		return "counsellor with Cid : "+cid+" is deleted successfully";
	}
	
	public List<Enquiry> getEnquiryByCid(Integer cid) {
		Counsellor counsellor = counsellorRepository.findById(cid)
				.orElseThrow(() -> new CounsellorNotFound("Counsellor Not found/Enter registered cid"));
		return counsellor.getEnquiries();
	}
}
