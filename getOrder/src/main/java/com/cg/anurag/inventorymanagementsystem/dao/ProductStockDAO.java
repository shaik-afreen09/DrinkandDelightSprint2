package com.cg.anurag.inventorymanagementsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.anurag.inventorymanagementsystem.dto.ProductStock;

@Repository
public interface ProductStockDAO extends JpaRepository<ProductStock,Integer>
{

}
