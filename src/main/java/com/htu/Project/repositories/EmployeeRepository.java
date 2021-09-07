package com.htu.Project.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.htu.Project.models.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer>{
	public List<Employee> findAll();
	
	@Query("SELECT e FROM Employee e WHERE CONCAT(e.name, ' ' , e.phoneNumber , ' ' , e.email) LIKE %?1%")
	public List<Employee> search(String keyword);
	
//	@Transactional
//	@Modifying
//	@Query("update Employee set dep_id = :departmentId where id = :id")
//	public void updateDepartment(@Param(value = "id") Integer id, @Param(value = "departmentId") Integer departmentId);

}
