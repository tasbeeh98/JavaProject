package com.htu.Project.services;

import java.sql.Time;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htu.Project.models.Attendance;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private EmployeeService employeeService;	 

	public Attendance create(Attendance attendance,Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		attendance.setEmployee(employee);
		return attendanceRepository.save(attendance);
	}
	public Time update( Integer id, Attendance attendance ) {
		attendanceRepository.addLeave(id,attendance.getDeparture(),attendance.getDayDate());
		return attendance.getDeparture();
	}
	
	public List<Attendance> getAttendanceEmployeeById(Integer id) {
		return attendanceRepository.findByEmployeeId(id);
	}
}

