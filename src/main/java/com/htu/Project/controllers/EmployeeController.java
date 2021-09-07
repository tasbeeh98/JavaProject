package com.htu.Project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.htu.Project.dtos.DepartmentDto;
import com.htu.Project.models.Department;
import com.htu.Project.models.Employee;
import com.htu.Project.services.DepartmentService;
import com.htu.Project.services.EmployeeService;
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeServices;
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping(value="/employee/{id}")
	public @ResponseBody Employee getEmployee(@PathVariable Integer id) {
		return employeeServices.getEmployeeById(id);
	}	
	@GetMapping(value="/employees")
	public @ResponseBody List<Employee> getEmployees() {
		 List<Employee> employeeList = employeeServices.getAllEmployee();
		 return employeeList;	
	}	
	@PostMapping(value="/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeServices.create(employee);
	}	
	@PutMapping(value="/employee/{id}")
	public Employee updateEmployee(@PathVariable Integer id , @RequestBody Employee employeeRequest ) {
		return employeeServices.updateEmployee(id, employeeRequest);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/employee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		 employeeServices.deleteEmployeeById(id);
	}
	
//	@PutMapping(value = "/department/{Id}/employee")
//	public @ResponseBody void createEmployeeInDepartment(@PathVariable Integer Id,@RequestBody Department department) {
//		departmentService.addEmployeeToDepartment(Id,department);
//	}
	
	@PutMapping(value = "/department/{Id}/employee")
	public Employee addrelation(@PathVariable Integer Id, @RequestBody DepartmentDto departmentDto ) {
		return employeeServices.addEmployeeToDepartment(Id, departmentDto);
		
	}
	
	@PutMapping(value = "/department/{Id}/employee/{departmentId}")
	public Employee addrelation(@PathVariable Integer Id, @PathVariable Integer departmentId ) {
		return employeeServices.em(Id, departmentId);
		
	}
}
