package com.htu.Project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htu.Project.models.Employee;
import com.htu.Project.services.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeServices;
	
	@GetMapping(value="/employee/{id}")
	public @ResponseBody Employee getStudent(@PathVariable Integer id) {
		return employeeServices.getEmployeeById(id);
	}
	
	@GetMapping(value="/employees")
	public List<Employee> getEmployees() {
		 List<Employee> employeeList = employeeServices.getAllEmployee();
		 return employeeList;
		
	}
	
	@PostMapping(value="/employee")
	public Employee createStudent(@RequestBody Employee employee) {
		return employeeServices.create(employee);
	
	}

}
