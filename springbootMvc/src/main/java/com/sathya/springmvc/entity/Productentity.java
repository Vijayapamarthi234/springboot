package com.sathya.springmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String name;
    private String brand;
    private String madein;
    private double price;
    private int quantity;
    private double discountrate;
    private double discountPrice;
    private double taxPrice;
    private double offerPrice;
    private double finalPrice;
    private double stockValue;
	
}
