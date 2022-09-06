package com.nt.start.Service;

import java.util.List;

import com.nt.start.Entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
