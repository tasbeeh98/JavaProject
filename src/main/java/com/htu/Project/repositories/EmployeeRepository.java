package com.htu.Project.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.htu.Project.models.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer>{
	public List<Employee> findAll();

}
