package com.cg.anurag.inventorymanagementsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.anurag.inventorymanagementsystem.dto.Admin;
@Repository
public interface AdminDAO extends JpaRepository<Admin,Integer> {
	
Admin findByUsername(String username);
}
