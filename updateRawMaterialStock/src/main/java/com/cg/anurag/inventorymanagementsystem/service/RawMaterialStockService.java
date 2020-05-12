package com.cg.anurag.inventorymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.anurag.inventorymanagementsystem.dao.RawMaterialStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
@Service
public class RawMaterialStockService {
	@Autowired
	RawMaterialStockDAO rmsdao;
	public void setpsdao(RawMaterialStockDAO psdao) { this.rmsdao=rmsdao;}

	 @Transactional
	public String updateStock(RawMaterialStock rawMaterialStock) {
		 RawMaterialStock rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
	    	if(rawMaterialStock1!=null)
	    	{
	    	  rawMaterialStock1.setManufacturingDate(rawMaterialStock.getManufacturingDate());
	    	  rawMaterialStock1.setExpiryDate(rawMaterialStock.getExpiryDate());
	    	  rawMaterialStock1.setQualityCheck(rawMaterialStock.getQualityCheck());
	    	  return "Updated Stock Sucessfully";
	    	}
	    	return null;
	}

}
