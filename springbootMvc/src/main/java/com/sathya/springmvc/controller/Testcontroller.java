package com.sathya.springmvc.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springmvc.entity.Productentity;
import com.sathya.springmvc.model.Productmodel;
import com.sathya.springmvc.service.Service;

import jakarta.validation.Valid;

@Controller
public class Testcontroller {
	@Autowired
	Service service;
	
	@GetMapping("/test")
	public String greet() {
		return "myview";
	}
/*@GetMapping("/productform")
public String getproductform()
{
	return "Add-product";
	
}*/
	@GetMapping("/productform")
	public String getproductform(Model model) {
		Productmodel productmodel=new Productmodel();
		productmodel.setMadein("INDIA");
		productmodel.setQuantity(2);
		productmodel.setDiscountrate(10.0);
		model.addAttribute("productmodel",productmodel);
		return "Add-product";
	}
	
@PostMapping("/saveproduct")
public String saveproduct(@Valid Productmodel productmodel,BindingResult bindingResult,Model model) {
	HashMap<String, String>validationerrors=new HashMap<String,String>();
	if(bindingResult.hasErrors()) {
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			validationerrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		model.addAttribute( "validationerrors",validationerrors);
		return "Add-product";
	}

	service.saveproductdetails(productmodel);
	return "redirect:/getallproducts";
}
/*@PostMapping("/saveproduct")
public String saveproduct(Productmodel productmodel)
{
	service.saveproductdetails(productmodel);
	System.out.print(productmodel);
	return "success";
}*/
@GetMapping("/getallproducts")
public String getallproducts(Model model)
{
	List<Productentity> product=service.getallproducts();
	model.addAttribute("Products", product);
	return "product-list";
}
@GetMapping("/getserchform")
public String getserchform(){
	return "search.product";
	
}
@PostMapping("/searchbyid")
public String searchbyid(@RequestParam long id,Model model) {
	
	Productentity product = service.searchById(id);
	model.addAttribute("product", product);
	return "search.product";
}
@GetMapping("/delete/{id}")
public String deleteproductbyid(@PathVariable long id) {
	
	service.deleteproductbyid(id);
	
	return "redirect:/getallproducts";
}
@GetMapping("/edit/{id}")
public String editbyproductid(@PathVariable long id,Model model) {
	
	Productmodel productmodel= service.getproductbyid(id);
	model.addAttribute("Productmodel",productmodel); 
	model.addAttribute("id",id);
	return "edit-product";
}
@PostMapping("/editbyproductid/{id}")
public String updateproduct(@PathVariable long id,Productmodel productmodel) {
	service.updateproduct(id,productmodel);
	return "redirect:/getallproducts";
	
}

}
