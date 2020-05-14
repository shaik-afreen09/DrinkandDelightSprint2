package com.cg.anurag.inventorymanagementsystem.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
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
	/*
	 * 
	 * 
	 * It creates order using HTTP Post 
	 */
	@PostMapping("productstock/createproductorder")
	   public ResponseEntity<ProductStock> createOrder(@RequestBody ProductStock product) throws NotFoundException
	   {
		   ProductStock productstock=productStockService.createOrder(product);
		   
		   if(productstock!=null)
				return	new ResponseEntity<ProductStock>(productstock, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Not Created");
	   }
	 
	/*
	 * It takes order id as input and fetchesentire order details
	 */
   @PostMapping("productstock/getOrder")
   public ResponseEntity<ProductStock> getOrder(@RequestBody ProductStock product) throws NotFoundException
   {
	   ProductStock productstock=productStockService.getOrder(product.getOrderId());
	   
	   if(productstock!=null)
			return	new ResponseEntity<ProductStock>(productstock, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Not FOund");
   }
   /*
    * 
    * It takes Order ID and exit Date from front end as input and updates in DB
    */
   @PutMapping(value="productstock/updateExitDate",consumes="application/json")
   public ResponseEntity<String> updateExitDate(@RequestBody()ProductStock productStock )
   {
	   String message=productStockService.updateExitDate(productStock);
	   if(message!=null)
			return	new ResponseEntity<String>(message, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Item Not Found");
   }
   /*
    * 
    * Fetch all Orders in the DB
    */
   @GetMapping("productstock/getAll")
   public List<ProductStock> getAll() throws NotFoundException
   {
	   return productStockService.getallOrder();
	  
	   
   }
   /*
    * Updates  Quality check, Manufacturing and Exit Date of Product
    */
   @PutMapping(value="productstock/updateStock",consumes="application/json")
   public ResponseEntity<String> updateStock(@RequestBody()ProductStock productStock)
   {
	  String message=productStockService.updateStock(productStock);
	  if(message!=null)
			return	new ResponseEntity<String>(message, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Item Not Found");
   }
  
}
  






