package com.cg.anurag.inventorymanagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.exception.NotFoundOperation;
import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;

import javassist.NotFoundException;

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
	//nullcheck 
   @GetMapping("productstock/getOrder/{orderId}")
   public ResponseEntity<ProductStock> getOrder(@PathVariable int orderId) throws NotFoundException
   {
	   ProductStock ps=productStockService.getOrder(orderId);
	   
	   if(ps!=null)
			return	new ResponseEntity<ProductStock>(ps, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Not FOund");
   }
   @PutMapping(value="productstock/updateExitDate",consumes="application/json")
   public ResponseEntity<String> updateExitDate(@RequestBody()ProductStock productStock )
   {
	   String ps=productStockService.updateExitDate(productStock);
	   if(ps!=null)
			return	new ResponseEntity<String>(ps, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Item Not Found");
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
  






