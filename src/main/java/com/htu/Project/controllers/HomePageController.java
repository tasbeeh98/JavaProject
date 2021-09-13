package com.htu.Project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.htu.Project.models.Attendance;
import com.htu.Project.models.DaysOff;
import com.htu.Project.models.Employee;
import com.htu.Project.services.AttendanceService;
import com.htu.Project.services.DaysOffService;
import com.htu.Project.services.EmployeeService;

@Controller
public class HomePageController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DaysOffService daysOFfService;
	
	@Autowired
	AttendanceService attendanceService;
		
	@GetMapping("/dashboard")
	public String getAllEmployee(Model model) {
		List <Employee>  employee =employeeService.getAllEmployee();
		model.addAttribute("employees", employee);
		return "dashboard";
	}
	
	@GetMapping("/all-attendance")
	public String getEmployeeAttendance(Model model) {
		List <Attendance>  attendance =attendanceService.getAllAttendance();
		model.addAttribute("attendances", attendance);
		return "attendance";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeService.create(employee);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable Integer id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);	
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) { 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/dashboard";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
	    List<Employee> employee = employeeService.listAll(keyword);
	    model.addAttribute("employees", employee);
	    model.addAttribute("keyword", keyword);	         
	    return "dashboard";
	    }
	
	@GetMapping("/search")
    public String searchAttendance(Model model, @Param("keyword") String keyword) {
        List<Attendance> attendance = attendanceService.listAll(keyword);
        model.addAttribute("attendances", attendance);
        model.addAttribute("keyword", keyword);	         
        return "attendance";
    }
	
//	@GetMapping("/search")
//    public String daysOff(Model model, @Param("keyword") String keyword) {
//        List<Attendance> attendance = attendanceService.listAll(keyword);
//        model.addAttribute("attendances", attendance);
//        model.addAttribute("keyword", keyword);	         
//        return "attendance";
//    }
	
	@GetMapping("/showFormForDaysOff")
	public String showDaysOff(Model model) {
		List<DaysOff> daysOff = daysOFfService.getAll();
		model.addAttribute("daysOff", daysOff);
		return "days_off";
	}
	
	@GetMapping("/updateFormForDaysOff/{id}/{did}")
	public String confirm(@PathVariable Integer id, @PathVariable Integer did,Model model) {	
		DaysOff daysOff = daysOFfService.getById(id);	
		model.addAttribute("daysOff", daysOff);
		return "add_status";
	}
	
	@PostMapping("/updateFormForDaysOff")
	public String update(DaysOff daysOff) {	
		daysOFfService.updateStatusFomr(daysOff.getId(),daysOff.getEmployee().getId(),daysOff);
		return "redirect:/showFormForDaysOff";
	}	
}
