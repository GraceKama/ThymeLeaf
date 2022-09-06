package com.nt.start.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.start.Dao.EmployeeDao;
import com.nt.start.Entity.Employee;

@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeDao.findAll();

	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeDao.save(employee);

	}

// findById returns Optional object
	@Override
	public Employee getEmployeeById(long id) {

		Optional<Employee> optional = employeeDao.findById(id);
		Employee employee = null;

		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id : : " + id);
		}
		return employee;

	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeDao.deleteById(id);
		
	}

}
