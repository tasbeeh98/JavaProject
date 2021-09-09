package com.htu.Project.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.Project.dtos.DepartmentDto;
import com.htu.Project.models.Department;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.DepartmentRepository;
import com.htu.Project.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isPresent()) {
			return employeeOptional.get();
		}
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Employee Not Found");
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
		
	public void deleteEmployeeById(Integer id) {
		Optional<Employee> entity = employeeRepository.findById(id); 
		if(entity.isPresent()) {
			employeeRepository.deleteById(id);
		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Employee Not Found");
		}
	}
	
	public Employee updateEmployee(Integer id, Employee employeeRequest ) {
		 Optional<Employee> employeeOptional  = employeeRepository.findById(id);
		 if(employeeOptional.isPresent()) {
			 Employee employeeObj = employeeOptional.get();
			 employeeObj.setName(employeeRequest.getName());
			 employeeObj.setEmail(employeeRequest.getEmail());
			 employeeObj.setPhoneNumber(employeeRequest.getPhoneNumber());
			 employeeRepository.save(employeeObj);
			 return employeeObj;
			 }
		 throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,"Employee Not Found");
	}	
	public List<Employee> listAll(String keyword) {
	        if (keyword != null) {
	            return employeeRepository.search(keyword);	            
	        }
	        return employeeRepository.findAll();
	 }
//	 public void createEmployeeInDepartment(Integer id,DepartmentDto departmentDto) {
//		 Optional<Employee> employeeOptional  = employeeRepository.findById(id);
//		 if(employeeOptional.isPresent()) {
//			 employeeRepository.updateDepartment(id,departmentDto.getDepartmentId());
//		 }
//		 else {throw new ResponseStatusException(
//				HttpStatus.NOT_FOUND,"Employee Not Found");
//		 }
//		}
	
	public Employee em(Integer id, Integer departmentId ) {
		 Optional<Employee> employeeOptional  = employeeRepository.findById(id);
		 if(employeeOptional.isPresent()) {
			 Optional<Department> departmentOptional  = departmentRepository.findById(departmentId);
			 if(departmentOptional.isPresent()) {
				 Employee e = employeeOptional.get();
				 e.setDepartment(departmentOptional.get());
				 return employeeRepository.save(e);
			 }
			 
			 }
		 throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,"Student Not Found");
		 }
	
	public Employee addEmployeeToDepartment(Integer id, DepartmentDto departmentDto ) {
		 Optional<Employee> employeeOptional  = employeeRepository.findById(id);
		 if(employeeOptional.isPresent()) {
			 Optional<Department> departmentOptional  = departmentRepository.findById(departmentDto.getDepartmentId());
			 if(departmentOptional.isPresent()) {
				 Employee e = employeeOptional.get();
				 e.setDepartment(departmentOptional.get());
				 return employeeRepository.save(e);
			 }
			 
			 }
		 throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,"Employee Not Found");
	 }
	
	}
	

