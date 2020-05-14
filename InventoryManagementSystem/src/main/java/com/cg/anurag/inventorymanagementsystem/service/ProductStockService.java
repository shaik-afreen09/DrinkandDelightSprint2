package com.cg.anurag.inventorymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.inventorymanagementsystem.dao.ProductStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;

import javassist.NotFoundException;
@Service
public class ProductStockService {
	@Autowired
    ProductStockDAO psdao;
	public void setpsdao(ProductStockDAO psdao) { this.psdao=psdao;}
	@Transactional(readOnly=true)
	public ProductStock getOrder(int orderId) throws NotFoundException
	{
		
			return psdao.findById(orderId).get();
		
	}
	@Transactional(readOnly=true)
	public List<ProductStock> getallOrder() {
		
			return psdao.findAll();
				
			}
	@Transactional
	public ProductStock createOrder(ProductStock product)
	{
		
		return	psdao.save(product);
			
		
		
		
		
		
		
	}
	
	 @Transactional
	    public String updateExitDate(ProductStock productStock)
	    {
		 ProductStock productStock1;
		 try
		 {
	    productStock1 = psdao.findById(productStock.getOrderId()).get();
		 }catch(Exception ex)
		 {
			 return null; 
		 }
		 productStock1.setDeliveryDate(productStock.getDeliveryDate());
	    	  productStock1.setExitDate(productStock.getExitDate());
	    	  return "Exit Date Modified";
	    	
	    	
	    }
	 @Transactional
	    public String updateStock(ProductStock productStock)
	    {
		 ProductStock productStock2 ;
		 try
		 {
		 productStock2 = psdao.findById(productStock.getOrderId()).get();
		 }
		 catch(Exception ex)
		 {
			 return null;
		 }
		
			 productStock2.setManufacturingDate(productStock.getManufacturingDate());
			 productStock2.setExpiryDate(productStock.getExpiryDate());
			 productStock2.setQualityCheck(productStock.getQualityCheck());
			 return " Updated Stock Sucessfully";
		 
		
	    }

	 

}
