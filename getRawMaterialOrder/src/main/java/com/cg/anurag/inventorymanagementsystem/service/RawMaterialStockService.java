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
	@Transactional(readOnly=true)
	public RawMaterialStock getOrder(int orderId) {
		// TODO Auto-generated method stub
		return rmsdao.findById(orderId).get();
	}
	
}
