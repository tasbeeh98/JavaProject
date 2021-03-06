package com.htu.Project.controllers;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.htu.Project.models.Attendance;
import com.htu.Project.services.AttendanceService;
@RestController
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService ;
	
	@PostMapping(value="/attendance/arrival/{id}")
	public Attendance addarrival(@PathVariable Integer id,@RequestBody Attendance attendance) {
		return attendanceService.create(attendance,id);
	}	
	
	@PutMapping(value="/attendance/departuer/{id}")
	public Time adddepartuer(@PathVariable Integer id,@RequestBody Attendance attendance) {
		return attendanceService.update(id,attendance);
	}
	
	@GetMapping(value="/attendance/{id}")
	public @ResponseBody List<Attendance> getAttendanceById(@PathVariable Integer id) {
		return attendanceService.getAttendanceEmployeeById(id);
	}
	
	@GetMapping(value="/attendance")
	public @ResponseBody List<Attendance> getAllAttendance() {
		return attendanceService.getAllAttendance();
	}

}
