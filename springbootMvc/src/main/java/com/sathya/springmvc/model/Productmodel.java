package com.sathya.springmvc.model;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productmodel {
	@NotBlank(message = "name cannot be blank")
	private String name;
	
	@NotBlank(message = "brand cannot be blank")
	private String brand;
	
	@NotBlank(message ="madein field cannot be blank")
	private String madein;
	
	@Positive(message = "price must be greater than zero")
	private double price;
	
	@Min(value =1,message = "quantity must be at least 1" )
	private int quantity;
	
	@DecimalMax(value = "100.0",message = "discountrate cannot exceed 100" )
	private double discountrate;
}
