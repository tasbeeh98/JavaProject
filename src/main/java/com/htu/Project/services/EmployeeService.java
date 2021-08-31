package com.htu.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.Project.models.Employee;
import com.htu.Project.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Student Not Found");
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

}
