package com.htu.Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.htu.Project.models.DaysOff;
import com.htu.Project.services.DaysOffService;

@RestController
public class DaysOffController {

	@Autowired
	DaysOffService daysOffService;
	
	@PostMapping(value="/dayOff/{id}")
	public DaysOff addarrival(@PathVariable Integer id,@RequestBody DaysOff daysOff) {
		return daysOffService.create(daysOff,id);
	}
	
	@PutMapping(value="/updateDayOff/{id}")
	public String update(@PathVariable Integer id,@RequestBody DaysOff daysOff) {
		return daysOffService.updateStatus(id,daysOff);
	}
}
