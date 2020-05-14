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

import com.cg.anurag.inventorymanagementsystem.dto.Admin;
import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.exception.NotFoundOperation;
import com.cg.anurag.inventorymanagementsystem.service.AdminService;
import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
public class AdminController {
	@Autowired
	AdminService adminservice;
	public void setAdminService(AdminService adminservice)
	{
		this.adminservice=adminservice;
	}
	/*
	 * It is login function where it takes admin object and eenables login functionality
	 * 
	 */
	@PutMapping(value="admin/login",consumes="application/json")
	   public ResponseEntity<String> adminlogin(@RequestBody()Admin admin)
	   {
		String ps=adminservice.login(admin);
		if(ps!=null)
			return	new ResponseEntity<String>(ps, HttpStatus.OK);
		else
		    throw new NotFoundOperation("Item Not Found");
		 
	   }
	/*
	 * 
	 * Forgot Password Functionality with feature of validating whether user exist or not
	 */
	   @PutMapping(value="admin/forgot",consumes="application/json")
	   public ResponseEntity<String> forgetpass(@RequestBody()Admin admin )
	   {
		   String ps=adminservice.forgotpassword(admin);
		   if(ps!=null)
				return	new ResponseEntity<String>(ps, HttpStatus.OK);
			else
			    throw new NotFoundOperation("Item Not Found");
	   }

}

