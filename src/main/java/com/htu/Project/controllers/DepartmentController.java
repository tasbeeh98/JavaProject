package com.htu.Project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.htu.Project.models.Department;
import com.htu.Project.services.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping(value="/department/{id}")
	public @ResponseBody List<Department> getDepartment(@PathVariable Integer id) {
		return departmentService.getDepById(id);
	}	
	@GetMapping(value="/departments")
	public List<Department> getDepartments() {
		 List<Department> departmentList = departmentService.getAllDep();
		 return departmentList;
	}
	@PostMapping(value="/department")
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.create(department);	
	}
//	@PostMapping(value="/addDepartment/{id}")
//	public Department addEmployeeToDepartment(@RequestBody Department department) {
//		return departmentService.update(department);	
//	}
}