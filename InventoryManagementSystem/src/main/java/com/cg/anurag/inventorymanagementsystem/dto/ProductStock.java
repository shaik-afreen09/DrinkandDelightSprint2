package com.cg.anurag.inventorymanagementsystem.dto;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="productstock")
public class ProductStock {	
	//select * from user_sequences; use this query to find sequence name if any issues
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "o_id")
	 @SequenceGenerator(name="o_id", sequenceName = "oid10", allocationSize=10)
	 @Column(name="orderid")
	 int orderId;
	 @Column(name="name")
	 String Name;
	 @Column(name="price_per_unit")
	 double pricePerUnit;
	 @Column(name="quantityvalue")
	 int quantityValue;
	 @Column(name="quantityunit")
	 int quantityUnit;
	 @Column(name="price")
	 double price;
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "w_id")
	 @SequenceGenerator(name="w_id", sequenceName = "wid20", allocationSize=10)
	 @Column(name="warehouseid")
	 String warehouseId;
	 @Column(name="deliverydate")
	 LocalDate deliveryDate;
	 @Column(name="manufacturingdate")
	 LocalDate manufacturingDate;
	 @Column(name="expirydate")
	 LocalDate expiryDate;
	 @Column(name="qualitycheck")
	 String qualityCheck;
	 @Column(name="exitdate")
	 LocalDate exitDate;
	 
	  
	 public ProductStock() {}
	public ProductStock(String name, int quantityValue, double pricePerUnit, int quantityUnit,
			double price, String warehouseId, LocalDate deliveryDate, LocalDate manufacturingDate, LocalDate expiryDate,
			String qualityCheck, LocalDate exitDate,int orderId) {
		super();
		
		this.Name = name;
		this.quantityValue = quantityValue;
		this.pricePerUnit = pricePerUnit;
		this.quantityUnit = quantityUnit;
		this.price = price;
		this.warehouseId = warehouseId;
		this.deliveryDate = deliveryDate;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.qualityCheck = qualityCheck;
		this.exitDate = exitDate;
		this.orderId = orderId;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(int quantityValue) {
		this.quantityValue = quantityValue;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public int getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(int quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	public LocalDate getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


}
