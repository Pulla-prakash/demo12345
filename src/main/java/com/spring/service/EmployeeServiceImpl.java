package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.beans.Employee;
import com.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getALlEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeeById(int id) {
		try {
			employeeRepository.deleteById(id);
		} 
		catch(DataAccessException e){
		throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

}
