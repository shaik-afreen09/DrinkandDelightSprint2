package com.cg.anurag.inventorymanagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
   @GetMapping("productstock/getOrder/{orderId}")
   public ProductStock getOrder(@PathVariable int orderId) throws NotFoundOperation
   {
	   return productStockService.getOrder(orderId);
   }
   
}
  






