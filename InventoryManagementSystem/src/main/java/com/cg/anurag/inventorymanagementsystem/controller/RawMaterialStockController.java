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
import com.cg.anurag.inventorymanagementsystem.service.RawMaterialStockService;

import javassist.NotFoundException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RawMaterialStockController {
 

		@Autowired
		RawMaterialStockService rawMaterialStockService;
		public void setRawMaterialStockService(RawMaterialStockService rawMaterialStockService)
		{
			this.rawMaterialStockService=rawMaterialStockService;
		}
		/*
		 * 
		 * Gets Raw Material Stock Order using HTTP POST Request and creates a record in Rawmaterialstock Table
		 */
		@PostMapping("rawmaterial/createrawmaterialorder")
		   public ResponseEntity<RawMaterialStock> createOrder(@RequestBody RawMaterialStock rms) throws NotFoundException
		   {
			RawMaterialStock rawmaterialstock=rawMaterialStockService.createOrder(rms);
			   
			   if(rawmaterialstock!=null)
					return	new ResponseEntity<RawMaterialStock>(rawmaterialstock, HttpStatus.OK);
				else
				    throw new NotFoundOperation("Not Created");
		   }
		/*
		 * Fetch Entire order using OrderID
		 */
	   @PostMapping("rawmaterial/getOrder")
	   public ResponseEntity<RawMaterialStock> getOrder(@RequestBody RawMaterialStock rms) throws NotFoundException
	   {
		   RawMaterialStock ps= rawMaterialStockService.getOrder(rms.getOrderId());
		   if(ps!=null)
				return	new ResponseEntity<RawMaterialStock>(ps, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Not FOund");
		   
	   }
	   /*
	    * Fetchs All Orders in DB
	    */
	   @GetMapping("rawmaterial/getAll")
	   public List<RawMaterialStock> getAll() throws NotFoundException
	   {
		   return rawMaterialStockService.getallOrder();
		  
		   
	   }
	   /*
	    * Updates Process Date of Order by Taking Order Id and other inputs
	    */
	   @PutMapping(value="rawmaterial/updateProcessDate",consumes="application/json")
	   public ResponseEntity<String> updateProcessDate(@RequestBody()RawMaterialStock rawMaterialStock )
	   {
		   String message=rawMaterialStockService.updateProcessDate(rawMaterialStock);
		   
		   
		   if(message!=null)
				return	new ResponseEntity<String>(message, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Item Not Found");
	   }
	   /*
	    * Updates  Quality check, Manufacturing and Exit Date of Raw Material
	    */
	   @PutMapping(value="rawmaterial/updateStock",consumes="application/json")
	   public ResponseEntity<String> updateStock(@RequestBody()RawMaterialStock rawMaterialStock)
	   {
		   String message=rawMaterialStockService.updateStock(rawMaterialStock);
		  
		 
		   if(message!=null)
				return	new ResponseEntity<String>(message, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Item Not Found");
	   }
	  
	}


