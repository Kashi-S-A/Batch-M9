package com.ty.empapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.empapp.entity.Employee;
import com.ty.empapp.service.EmpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class EmpController {
	
	private EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService=empService;
	}

	@GetMapping("/")
	public ModelAndView getRegister() {
		ModelAndView mv=new ModelAndView("index.jsp");
		mv.addObject("employee", new Employee());
		return mv;
	}
	
	@PostMapping("/save")
	public ModelAndView saveEmployee(Employee employee) {
		
		String msg = empService.save(employee);
		
		ModelAndView mv=new ModelAndView("login.jsp");
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	
}
