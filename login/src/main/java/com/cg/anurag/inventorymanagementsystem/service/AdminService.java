package com.cg.anurag.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.inventorymanagementsystem.dao.AdminDAO;

import com.cg.anurag.inventorymanagementsystem.dto.Admin;



@Service
public class AdminService {
	
	
	@Autowired
    AdminDAO psdao;
	public void setpsdao(AdminDAO psdao) { this.psdao=psdao;}
	
@Transactional
public String login(Admin admin)
{
	Admin admin1;
try
{
	admin1 = psdao.findByUsername(admin.getUsername());
}
	catch(Exception ex)
{
		return null;
	}
	if(!admin.getPassword().equals(admin1.password))
	{
		return "user not exist";
	}	
	return "success";		
}
}