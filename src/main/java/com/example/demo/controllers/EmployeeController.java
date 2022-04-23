package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@RequestMapping("/new")
	public String displayEmployeeForm(Model model) {

		model.addAttribute("employee", new Employee());
		return "new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRepo.save(employee);
		
		return "redirect:/employees/new";
	}
	
}
