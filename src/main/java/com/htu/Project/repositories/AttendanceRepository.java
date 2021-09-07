package com.htu.Project.repositories;

import java.sql.Time;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.htu.Project.models.Attendance;

public interface AttendanceRepository extends CrudRepository <Attendance, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Attendance set departure = :departure where employee_id = :employee_id and day_date = :day_date")
	public void addLeave(@Param(value = "employee_id") Integer employee_id, @Param(value = "departure") Time departure , @Param (value = "day_date") Date day_date);

}
