package com.htu.Project.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.htu.Project.models.DaysOff;
import com.htu.Project.models.Employee;
import com.htu.Project.repositories.DaysOffRepository;

@Service
public class DaysOffService {

	@Autowired
	private DaysOffRepository daysOffRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public List<DaysOff> getAll(){
		return daysOffRepository.findAll();
	}
	
	public DaysOff getById(Integer id) {
		Optional<DaysOff> daysOffOp = daysOffRepository.findById(id);
		if (daysOffOp.isPresent()) {
			return daysOffOp.get();
		}
		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,"Not Found");			
	}
		
	public DaysOff create(DaysOff daysOff,Integer id) {
		Employee employee = employeeService.getEmployeeById(id);
		daysOff.setEmployee(employee);
		return daysOffRepository.save(daysOff);
	}
	
	public String updateStatus(Integer id, DaysOff daysOffRequest ) {
		daysOffRepository.updateTheStatus(id, daysOffRequest.getStatus(), daysOffRequest.getDayDate());
		return daysOffRequest.getStatus();
	}
	
	public String updateStatusFomr(Integer id,Integer did, DaysOff daysOffRequest ) {
		daysOffRepository.updateTheStatusForm(id,did,daysOffRequest.getStatus());
		return daysOffRequest.getStatus();
	}
	
	public List<DaysOff> listAll(String keyword) {
        if (keyword != null) {
            return daysOffRepository.searchDaysOff(keyword);	            
        }
        return daysOffRepository.findAll();
	}
	
}
