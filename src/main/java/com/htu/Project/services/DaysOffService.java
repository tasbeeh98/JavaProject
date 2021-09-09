package com.htu.Project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htu.Project.models.DaysOff;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.DaysOffRepository;

@Service
public class DaysOffService {

	@Autowired
	private DaysOffRepository daysOffRepository;
	
	@Autowired
	private EmployeeService employeeService;
		
	public DaysOff create(DaysOff daysOff,Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		daysOff.setEmployee(employee);
		return daysOffRepository.save(daysOff);
	}
	
	public String updateStatus(Integer id, DaysOff daysOffRequest ) {
		daysOffRepository.updateTheStatus(id, daysOffRequest.getStatus(), daysOffRequest.getDayDate());
		return daysOffRequest.getStatus();
	}
}
