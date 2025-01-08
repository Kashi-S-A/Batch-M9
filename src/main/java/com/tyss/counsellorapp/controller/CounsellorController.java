package com.tyss.counsellorapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.counsellorapp.dto.CounsellorRequest;
import com.tyss.counsellorapp.dto.CounsellorResponse;
import com.tyss.counsellorapp.entity.Counsellor;
import com.tyss.counsellorapp.entity.Enquiry;
import com.tyss.counsellorapp.service.CousellorService;

@RestController
@RequestMapping("/counsellor")
//@CrossOrigin(origins = "http://localhost:3000")
public class CounsellorController {

	private CousellorService cousellorService;

	public CounsellorController(CousellorService cousellorService) {
		this.cousellorService = cousellorService;
	}

	@PostMapping(value = "/register", consumes = { "application/json", "application/xml" },
									  produces = {"application/json", "application/xml" }
	)
	public ResponseEntity<String> registerCounsellor(@RequestBody CounsellorRequest counsellorRequest) {
		boolean registered = cousellorService.registerCounsellor(counsellorRequest);
		if (registered) {
			return new ResponseEntity<String>("register", HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().body("already registered");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
		boolean login = cousellorService.login(email, password);
		if (login) {
			return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Login failed", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value="/update/{id}",consumes = { "application/json", "application/xml" },
			                         produces = {"application/json", "application/xml" }
	)
	public ResponseEntity<CounsellorResponse> updateCounsellor(@PathVariable Integer id, @RequestBody CounsellorRequest counsellorRequest) {
		Counsellor updateCounsellor = cousellorService.updateCounsellor(id, counsellorRequest);
		
		CounsellorResponse cr=new CounsellorResponse();
		
		BeanUtils.copyProperties(updateCounsellor, cr);
		
		return new ResponseEntity<CounsellorResponse>(cr, HttpStatus.OK);
	}
	
	@PatchMapping("/pwd/{id}/{password}")
	public ResponseEntity<String> updatePassword(@PathVariable Integer id,@PathVariable String password) {
		String updatePwd = cousellorService.updatePwd(id,password);
		return new ResponseEntity<String>(updatePwd, HttpStatus.OK);
	}

	@DeleteMapping("/del/{cid}")
	public ResponseEntity<String> deleteCounsellor(@PathVariable Integer cid) {
		String deleteCounsellor = cousellorService.deleteCounsellor(cid);
		return new ResponseEntity<String>(deleteCounsellor, HttpStatus.OK);
	}
	
	@GetMapping("/allenq")
	public ResponseEntity<List<Enquiry>> getEnquiriesByCid(@RequestParam Integer cid) {
		List<Enquiry> enquiries = cousellorService.getEnquiryByCid(cid);
		return new ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
	}
	
}
