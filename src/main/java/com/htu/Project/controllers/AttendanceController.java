package com.htu.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Attendance adddepartuer(@PathVariable Integer id,@RequestBody Attendance attendance) {
		return attendanceService.update(id,attendance);
	}

}
