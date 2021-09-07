package com.htu.Project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.htu.Project.models.Department;

public interface DepartmentRepository extends CrudRepository <Department, Integer>{
	public List<Department> findAll();
	public List<Department> findAllById(Integer id);

}
