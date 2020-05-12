package com.cg.anurag.inventorymanagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.exception.NotFoundOperation;
import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;

import brave.sampler.Sampler;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
public class ProductStockController
{
	@Autowired
	ProductStockService productStockService;
	public void setProductStockService(ProductStockService productStockService)
	{
		this.productStockService=productStockService;
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
   @PutMapping(value="productstock/updateStock",consumes="application/json")
   public ResponseEntity<String> updateStock(@RequestBody()ProductStock productStock)
   {
	   String ps=productStockService.updateStock(productStock);
		  if(ps!=null)
				return	new ResponseEntity<String>(ps, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Item Not Found");
   }
  
}
  






