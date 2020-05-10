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
	    public String updateStock(ProductStock productStock)
	    {
		 ProductStock productStock2 = psdao.findById(productStock.getOrderId()).get();
		 if(productStock2!=null)
		 {
			 productStock2.setManufacturingDate(productStock.getManufacturingDate());
			 productStock2.setExpiryDate(productStock.getExpiryDate());
			 productStock2.setQualityCheck(productStock.getQualityCheck());
			 return " Updated Stock Sucessfully";
		 }
		 return "Updation Failed";
	    }

	 

}
