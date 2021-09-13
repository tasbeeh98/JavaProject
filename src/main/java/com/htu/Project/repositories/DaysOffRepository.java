package com.htu.Project.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.htu.Project.models.DaysOff;

public interface DaysOffRepository extends CrudRepository <DaysOff, Integer>{
	
	public List<DaysOff> findAll();
	
	@Transactional
	@Modifying
	@Query("update days_off set status = :status where employee_id = :employee_id and day_date = :day_date")
	public void updateTheStatus(@Param(value = "employee_id") Integer employee_id, @Param(value = "status") String status , @Param (value = "day_date") Date day_date);

	@Transactional
	@Modifying
	@Query("update days_off set status = :status where employee_id = :employee_id and id = :id")
	public void updateTheStatusForm(@Param(value = "id") Integer id ,@Param(value = "employee_id") Integer employee_id, @Param(value = "status") String status);

	@Query("SELECT a FROM days_off a JOIN a.employee e WHERE CONCAT(e.id, '  ', e.name, '  ',a.description, ' ' , a.dayDate) LIKE %?1%")
	public List<DaysOff> searchDaysOff(String keyword);
}
