package com.htu.Project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.htu.Project.models.Employee;
import com.htu.Project.services.EmployeeService;

@Controller
public class HomePageController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/home-home")
	public String getAllEmployees(Model model) {
		List <Employee>  employee =employeeService.getAllEmployee();
		model.addAttribute("employees", employee);
		return "home";
	}
		
	@GetMapping("/dashboard")
	public String getAllEmployee(Model model) {
		List <Employee>  employee =employeeService.getAllEmployee();
		model.addAttribute("employees", employee);
		return "dashboard";
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
		return "redirect:/home";
	}

	@GetMapping("/login")
	public String nh() {
		return "login";
	}
	
//	@GetMapping("/dashboard")
//	public String dashboard() {
//		return "dashboard";
//	}
	
	@GetMapping("/")
	    public String viewHomePage(Model model, @Param("keyword") String keyword) {
	        List<Employee> employee = employeeService.listAll(keyword);
	        model.addAttribute("employees", employee);
	        model.addAttribute("keyword", keyword);	         
	        return "dashboard";
	    }
}
