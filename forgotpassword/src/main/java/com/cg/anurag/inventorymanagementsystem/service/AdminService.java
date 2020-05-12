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
public String forgotpassword(Admin admin)
{
	Admin admin1;
try {
	admin1 = psdao.findByUsername(admin.getUsername());
}catch(Exception ex)
{
	return null;
	}
	
		admin1.setPassword(admin.getPassword());
		return "Password Updated Successfully";
			
	
}
}
