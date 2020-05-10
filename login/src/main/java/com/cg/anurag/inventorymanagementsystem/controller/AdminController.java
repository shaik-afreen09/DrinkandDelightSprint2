package com.cg.anurag.inventorymanagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.anurag.inventorymanagementsystem.dto.Admin;
//import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.service.AdminService;

import brave.sampler.Sampler;
//import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;




@CrossOrigin(origins = "http://localhost:4200")
@RestController 
public class AdminController {
	@Autowired
	AdminService adminservice;
	public void setAdminService(AdminService adminservice)
	{
		this.adminservice=adminservice;
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	@PutMapping(value="admin/login",consumes="application/json")
	   public String getOrder(@RequestBody()Admin admin)
	   {
		   return adminservice.login(admin);
	   }
	   

}

