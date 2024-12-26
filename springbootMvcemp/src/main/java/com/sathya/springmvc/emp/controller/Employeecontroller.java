package com.sathya.springmvc.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springmvc.emp.entity.Employeeentity;
import com.sathya.springmvc.emp.model.Employeemodel;
import com.sathya.springmvc.emp.service.Employeeservice;


@Controller
public class Employeecontroller {
	@Autowired
	Employeeservice employeeservice;
	@GetMapping("/employeeform")
	public String getemployeeform()
	{
		return "employee";
	}
	@PostMapping("/saveemployee")
	public String saveemployee(Employeemodel employee)
	{
		employeeservice.saveemployeedetails(employee);
		System.out.print(employee);
		return "done";
	}
@GetMapping("/getallemployeedetails")
public String getallemployeedetails(Model model) {
	List<Employeeentity>employee=employeeservice.getallemployeedetails();
	model.addAttribute("Employee",employee);
	return "employee-list";
}
@GetMapping("/searchform")
public String getearchform(){
	return "search-employee";
}
@PostMapping("/searchbyid")
public String searchbyid(@RequestParam long id,Model model) {
	Employeeentity employee=employeeservice.searchbyid(id);
	model.addAttribute( "Employee",employee);
	return "search-employee";
	
}
@GetMapping("/delete/{id}")
public String deleteemployeebyid(@PathVariable long id) {
	employeeservice.deleteemployeebyid(id);
	return "redirect:/getallemployeedetails";
}
@GetMapping("/edit/{id}")
public String editemployeebyid(@PathVariable long id,Model model) {
	Employeemodel employeemodel =employeeservice.editemployeebyid(id);
	model.addAttribute("Employee",employeemodel);
	return "edit-employee";
}
@PostMapping("/editbyemployeeid/{id}")
public String updateemployee(@PathVariable long id,Employeemodel employeemodel) {
	employeeservice.updateproduct(id,employeemodel);
	return "redirect:/getallproducts";
	
}
}
