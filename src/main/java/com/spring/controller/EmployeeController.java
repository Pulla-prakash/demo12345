package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.Employee;
import com.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/emplist")
	public String getAllEmployees(Model model) {
		List<Employee> list = employeeService.getALlEmployees();
		model.addAttribute("emplist", list);
		return "emplist";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteProduct(Model model,@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		
        List<Employee> list = employeeService.getALlEmployees();
		
		model.addAttribute("emplist", list);
		
		return "emplist";
		
	}
	
	@GetMapping("/editEmployee/{id}")
	public String getProductById(Model model,@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employee";
	}
	
	
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public String addProduct(Model model,@ModelAttribute(value="employee") Employee employee) {
		
		if(employee.getId()==0) {
			int Random =(int)(Math.random()*90);
			employee.setId(Random);
			employeeService.addEmployee(employee);
		}
		else {
			employeeService.updateEmployee(employee);
		}

        List<Employee> emplist = employeeService.getALlEmployees();
		
		model.addAttribute("emplist", emplist);
		
		return "emplist";
	}

	
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String newEmployee(Model model,@ModelAttribute(value="employee") Employee employee) {
		model.addAttribute("employee", employee);
		return "employee";
		
	}
}
