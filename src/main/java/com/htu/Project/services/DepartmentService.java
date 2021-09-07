package com.htu.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.Project.models.Department;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@Autowired
	EmployeeService employeeService;
	
	public List<Department> getAllDep () {
		return departmentRepo.findAll();
	}
	
	public List<Department> getDepById (Integer id) {
		return departmentRepo.findAllById(id);
	}
	
	public Department create(Department department) {
		return departmentRepo.save(department);
		
	}
	
	public Department getDepartmentById(Integer id) {
		Optional<Department> departmentOp = departmentRepo.findById(id);
		if (departmentOp.isPresent()) {
			return departmentOp.get();
		}
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Student Not Found");
		}	
	
//	public Department addEmployeeToDepartment(Integer employeeId,Department department) {
//		Employee employee = employeeService.getEmployeeById(employeeId);
//		department.setEmployees(employee.setDepartment(department.getId()));
//		return departmentRepo.save(department);
//		
//	}
	
}
