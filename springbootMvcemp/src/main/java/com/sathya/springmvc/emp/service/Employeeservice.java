package com.sathya.springmvc.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springmvc.emp.entity.Employeeentity;
import com.sathya.springmvc.emp.model.Employeemodel;
import com.sathya.springmvc.emp.repository.Employeerepository;

@Service
public class Employeeservice {
	@Autowired
	Employeerepository employeerepository;
	
	public void saveemployeedetails (Employeemodel employeemodel) {
		double da;
		da=employeemodel.getSalary()*0.1;
		double hra;
		hra=employeemodel.getSalary()*0.9;
		double totalsalary;
		totalsalary=employeemodel.getSalary()+da+hra;
		Employeeentity employeeentity=new Employeeentity();
		employeeentity.setName(employeemodel.getName());
		employeeentity.setPhoneno(employeemodel.getPhoneno());
		employeeentity.setGender(employeemodel.getGender());
		employeeentity.setDoj(employeemodel.getDoj());
		employeeentity.setDeptname(employeemodel.getDeptname());
		employeeentity.setSalary(employeemodel.getSalary());
		employeeentity.setDa(da);
		employeeentity.setHra(hra);
		employeeentity.setTotalsalary(totalsalary);
	employeerepository.save(employeeentity);
	}
	public List<Employeeentity> getallemployeedetails(){
		List<Employeeentity>employee=employeerepository.findAll();
		return employee;
		
	}
	public Employeeentity searchbyid(long id) {
		Optional<Employeeentity>optionaldata=employeerepository.findById(id);
		if(optionaldata.isPresent()) {
			Employeeentity employee=optionaldata.get();
			return employee; 
		}
		else
		{
			return null;
		}
	}
	public void deleteemployeebyid(long id) {
		employeerepository.deleteById(id);
	
		
	}
	public Employeemodel editemployeebyid(long id) 
	{
		Optional<Employeeentity>optionaldata=employeerepository.findById(id);
		if(optionaldata.isPresent()) {
			Employeeentity employeeentity=optionaldata.get();
			Employeemodel employeemodel=new Employeemodel();
			employeemodel.setName(employeeentity.getName());
			employeemodel.setDeptname(employeeentity.getDeptname());
			employeemodel.setDoj(employeeentity.getDoj());
			employeemodel.setGender(employeeentity.getGender());
			employeemodel.setPhoneno(employeeentity.getPhoneno());
			employeemodel.setSalary(employeeentity.getSalary());
			return employeemodel;
		
		
		}
		else {
			return  null;
	}
	public void updateproduct(long id, Employeemodel employeemodel) {
		Optional<Employeeentity>optionaldata=employeerepository.findById(id);
		if(optionaldata.isPresent()) {
			Employeeentity employeeentity=optionaldata.get();
			Employeeentity employeeentity=new Employeeentity();	
			double da;
			da=employeemodel.getSalary()*0.1;
			double hra;
			hra=employeemodel.getSalary()*0.9;
			double totalsalary;
			totalsalary=employeemodel.getSalary()+da+hra;
			employeeentity.setName(employeemodel.getName());
			employeeentity.setPhoneno(employeemodel.getPhoneno());
			employeeentity.setGender(employeemodel.getGender());
			employeeentity.setDoj(employeemodel.getDoj());
			employeeentity.setDeptname(employeemodel.getDeptname());
			employeeentity.setSalary(employeemodel.getSalary());
			employeeentity.setDa(da);
			employeeentity.setHra(hra);
			employeeentity.setTotalsalary(totalsalary);
		employeerepository.save(employeeentity);
		}
		
	}
}
