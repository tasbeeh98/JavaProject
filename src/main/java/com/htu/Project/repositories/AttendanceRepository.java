package com.htu.Project.repositories;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.htu.Project.models.Attendance;

public interface AttendanceRepository extends CrudRepository <Attendance, Integer> {
	
	public List<Attendance> findAll();	
	public List<Attendance> findByEmployeeId(Integer id);
	
	@Transactional
	@Modifying
	@Query("update Attendance set departure = :departure where employee_id = :employee_id and day_date = :day_date")
	public void addLeave(@Param(value = "employee_id") Integer employee_id, @Param(value = "departure") Time departure , @Param (value = "day_date") Date day_date);

	@Query("SELECT a FROM Attendance a JOIN a.employee e  WHERE CONCAT(e.id, '  ', e.name, '  ',a.arrival, ' ' , a.departure , ' ' , a.dayDate) LIKE %?1%")
	public List<Attendance> searchAttendance(String keyword);
	
//	@Query("SELECT a FROM Attendance a WHERE CONCAT(a.arrival, ' ' , a.departure , ' ' , a.dayDate) LIKE %?1%")
//	public List<Attendance> searchAttendance(String keyword);
	
}
