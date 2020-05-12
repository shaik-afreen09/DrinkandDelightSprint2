package com.cg.anurag.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.inventorymanagementsystem.dao.ProductStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
@Service
public class ProductStockService {
	@Autowired
    ProductStockDAO psdao;
	public void setpsdao(ProductStockDAO psdao) { this.psdao=psdao;}
	
	 @Transactional
	    public String updateExitDate(ProductStock productStock)
	    {
	    	ProductStock productStock1 = psdao.findById(productStock.getOrderId()).get();
	    	if(productStock1!=null)
	    	{
	    	  productStock1.setExitDate(productStock.getExitDate());
	    	  return "Exit Date Modified";
	    	}
	    	return null;
	    }
	 

	 

}
