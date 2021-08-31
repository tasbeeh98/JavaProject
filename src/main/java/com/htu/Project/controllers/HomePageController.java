package com.htu.Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.htu.Project.models.Employee;
import com.htu.Project.services.EmployeeService;

@Controller
public class HomePageController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/home-home")
	public String getAllEmployees(Model model) {
		List <Employee>  employee =employeeService.getAllEmployee();
		model.addAttribute("employees", employee);
		return "home";
	}
		
	@GetMapping("/home")
	public String getAllEmployee(Model model) {
		List <Employee>  employee =employeeService.getAllEmployee();
		model.addAttribute("employees", employee);
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeService.create(employee);
		return "redirect:/home";
	}

	@GetMapping("/login")
	public String nh() {
		return "login";
	}

}
