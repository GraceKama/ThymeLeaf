package com.nt.start.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nt.start.Entity.Employee;
import com.nt.start.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	//show new employee
	//
	@GetMapping("/showNewEmployeeForm")
	//@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String ShowNewEmployeeForm(Model model) {
		//create model attribute to bing form data.
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
		
	}
	
	// If you want to read entire data from form use ModelAttribute.
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
		//save Employee to database
		
		employeeService.saveEmployee(employee);
		return "redirect:/";  // redirecting to home page.
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String ShowFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		//get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as as Model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	
	//for Mandatory fields use @PathVariable ex:id for delete,
	//for optional fields use @RequestParam ex : search emp by id,last name or first name.
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		//call delete employee method 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}

}
