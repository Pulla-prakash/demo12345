package com.spring.service;

import java.util.List;

import com.spring.beans.Employee;



public interface EmployeeService {
	
	List<Employee> getALlEmployees();
	
	void deleteEmployeeById(int id);
	
	Employee getEmployeeById(int id);
	
	void updateEmployee(Employee employee);
	
	Employee addEmployee(Employee employee);
	
	

}
