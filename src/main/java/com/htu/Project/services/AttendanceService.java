package com.htu.Project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.Project.models.Attendance;
import com.htu.Project.models.Department;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.AttendanceRepository;
import com.htu.Project.repositories.EmployeeRepository;

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
	public Attendance update( Integer id, Attendance attendance ) {
		attendanceRepository.addLeave(id,attendance.getDeparture(),attendance.getDayDate());
		return attendance;
	}
}

