package com.cg.anurag.inventorymanagementsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
@Repository
public interface RawMaterialStockDAO extends JpaRepository<RawMaterialStock,Integer>
{

}
