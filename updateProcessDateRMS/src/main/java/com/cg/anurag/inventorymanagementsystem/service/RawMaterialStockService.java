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
	    public String updateProcessDate(RawMaterialStock rawMaterialStock)
	    {
	    	RawMaterialStock rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
	    	if(rawMaterialStock1!=null)
	    	{
	    	  rawMaterialStock1.setProcessDate(rawMaterialStock.getProcessDate());
	    	  return "Process Date Modified";
	    	}
	    	return null;
	    }
	 

}
