package com.sathya.springmvc.service;

import java.util.List;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sathya.springmvc.entity.Productentity;
import com.sathya.springmvc.model.Productmodel;
import com.sathya.springmvc.repository.Repository;
@org.springframework.stereotype.Service

public class Service {
@Autowired
Repository repository;
public void saveproductdetails(Productmodel productmodel)
{
	double stockValue;
	stockValue=productmodel.getPrice()*productmodel.getQuantity();
	double discountPrice;
	discountPrice=(productmodel.getPrice()*productmodel.getDiscountrate()) / 100;
	double offerPrice;
	offerPrice=productmodel.getPrice() - discountPrice;
	double taxPrice;
	taxPrice=0.18 * offerPrice;
	double finalPrice;
	finalPrice=offerPrice + taxPrice;
	
	Productentity productentity=new Productentity();
	productentity.setName(productmodel.getName());
	productentity.setBrand(productmodel.getBrand());
	productentity.setMadein(productmodel.getMadein());
	productentity.setPrice(productmodel.getPrice());
	productentity.setQuantity(productmodel.getQuantity());
	productentity.setDiscountrate(productmodel.getDiscountrate());
	productentity.setDiscountPrice(discountPrice);
	productentity.setStockValue(stockValue);
	productentity.setTaxPrice(taxPrice);
	productentity.setFinalPrice(finalPrice);
	productentity.setOfferPrice(offerPrice);
	repository.save(productentity);
}
    public List<Productentity> getallproducts()
    {
    	List<Productentity> product = repository.findAll();
    	return product; 
    }
    public Productentity searchById (long id) {
    	Optional<Productentity> optionaldata=repository.findById(id);
    	if(optionaldata.isPresent()) 
    	{
    		Productentity product = optionaldata.get();
    		return product;
    	}
    	else
    	{
    		return null;
    	} 
    	}
    
    
	public void deleteproductbyid(long id) {
		repository.deleteById(id);		
	
	}
	public Productmodel getproductbyid(long id) {
Optional<Productentity>optional=repository.findById(id);
		
		if(optional.isPresent()) {
			Productentity productentity=optional.get();
			Productmodel productmodel=new Productmodel();
			productmodel.setName(productentity.getName());
			productmodel.setBrand(productentity.getBrand());
			productmodel.setMadein(productentity.getMadein());
			productmodel.setPrice(productentity.getPrice());
			productmodel.setQuantity(productentity.getQuantity());
			productmodel.setDiscountrate(productentity.getDiscountrate());
		return productmodel;
	}
		else {
			return null;
		}
		}
	public void updateproduct(long id, Productmodel productmodel) {
		Optional<Productentity>optional=repository.findById(id);
		
		if(optional.isPresent()) {
			Productentity productentity=optional.get();
			
			productentity.setName(productmodel.getName());
			productentity.setBrand(productmodel.getBrand());
			productentity.setMadein(productmodel.getMadein());
			productentity.setPrice(productmodel.getPrice());
			productentity.setQuantity(productmodel.getQuantity());
			productentity.setDiscountrate(productmodel.getDiscountrate());
			double stockValue;
			stockValue=productmodel.getPrice()*productmodel.getQuantity();
			double discountPrice;
			discountPrice=(productmodel.getPrice()*productmodel.getDiscountrate()) / 100;
			double offerPrice;
			offerPrice=productmodel.getPrice() - discountPrice;
			double taxPrice;
			taxPrice=0.18 * offerPrice;
			double finalPrice;
			finalPrice=offerPrice + taxPrice;
			productentity.setDiscountPrice(discountPrice);
			productentity.setStockValue(stockValue);
			productentity.setTaxPrice(taxPrice);
			productentity.setFinalPrice(finalPrice);
			productentity.setOfferPrice(offerPrice);
			repository.save(productentity);
			
			
		}

		
	}
	
    }



