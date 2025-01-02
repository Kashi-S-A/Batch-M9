package com.ty.empapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.empapp.entity.Employee;
import com.ty.empapp.service.EmpService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmpController {

	private EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping("/")
	public ModelAndView getRegister() {
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("employee", new Employee());
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView addEmployee() {
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("employee", new Employee());
		return mv;
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login.jsp";
	}

	@PostMapping("/save")
	public ModelAndView saveEmployee(Employee employee) {

		String msg = empService.save(employee);

		ModelAndView mv = new ModelAndView("login.jsp");
		mv.addObject("msg", msg);

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean login = empService.login(email, password);

		ModelAndView mv = new ModelAndView();

		if (login) {
			mv.setViewName("home.jsp");

			List<Employee> employees = empService.getAll();

			mv.addObject("emps", employees);
			mv.addObject("msg", "Login Successful");
		} else {
			mv.setViewName("login.jsp");
			mv.addObject("msg", "Invalid credentials");
		}
		return mv;
	}

	@GetMapping("/home")
	public ModelAndView getMethodName() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");

		List<Employee> employees = empService.getAll();

		mv.addObject("emps", employees);
		return mv;
	}

	@PostMapping("/add")
	public ModelAndView addEmployee(Employee employee) {

		String msg = empService.update(employee);

		ModelAndView mv = new ModelAndView("add.jsp");
		mv.addObject("msg", msg);

		return mv;
	}

	@GetMapping("/edit")
	public ModelAndView editEmployee(@RequestParam Integer eid) {
		Employee employee = empService.findById(eid);
		ModelAndView mv = new ModelAndView("add.jsp");
		mv.addObject("employee", employee);
		return mv;
	}

	@GetMapping("/delete")
	public ModelAndView getMethodName(@RequestParam Integer eid) {

		String msg = empService.deleteByEid(eid);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");

		List<Employee> employees = empService.getAll();

		mv.addObject("emps", employees);
		mv.addObject("msg", msg);
		return mv;
	}

}
