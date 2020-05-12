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
		
	   @GetMapping("rawmaterial/getOrder/{orderId}")
	   public ResponseEntity<RawMaterialStock> getOrder(@PathVariable int orderId) throws NotFoundException
	   {
		   RawMaterialStock ps= rawMaterialStockService.getOrder(orderId);
		   if(ps!=null)
				return	new ResponseEntity<RawMaterialStock>(ps, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Not FOund");
		   
	   }
	   @PutMapping(value="rawmaterial/updateProcessDate",consumes="application/json")
	   public ResponseEntity<String> updateProcessDate(@RequestBody()RawMaterialStock rawMaterialStock )
	   {
		   String message=rawMaterialStockService.updateProcessDate(rawMaterialStock);
		   
		   
		   if(message!=null)
				return	new ResponseEntity<String>(message, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Item Not Found");
	   }
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


