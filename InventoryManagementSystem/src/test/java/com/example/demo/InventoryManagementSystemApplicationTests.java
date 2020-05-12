package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.anurag.inventorymanagementsystem.InventoryManagementSystemApplication;
import com.cg.anurag.inventorymanagementsystem.dao.RawMaterialStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
import com.cg.anurag.inventorymanagementsystem.service.AdminService;
import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;
import com.cg.anurag.inventorymanagementsystem.service.RawMaterialStockService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=InventoryManagementSystemApplication.class)
@AutoConfigureMockMvc
public class InventoryManagementSystemApplicationTests {

	@Autowired
	MockMvc mc;
	@MockBean
	RawMaterialStockService rms;
	@MockBean
	ProductStockService ps;
	@MockBean
	AdminService admin;
	
	@Test
	public void checkmaterialorder() throws Exception
	{
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.get("/rawmaterial/getOrder/100").contentType(MediaType.APPLICATION_JSON);
MvcResult m=mc.perform(rc).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
System.out.println(m.getResponse());

	}
	@Test
	public void processDate() throws Exception
	{
		
		String json="{\"name\":\"\",\"pricePerUnit\":0,\"quantityValue\":0,\"quantityUnit\":0,\"price\":0,\"warehouseId\":\"\",\"deliveryDate\":\"\",\"manufacturingDate\":\"\",\"expiryDate\":\"\",\"qualityCheck\":\"\",\"processDate\":\"2020-05-08\",\"orderId\":100}";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/rawmaterialstock/updateProcessDate").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		
		System.out.println(m.getResponse());
		
	}
	@Test
	public void updatestock() throws Exception
	{
		
		String json="{\"name\":\"\",\"pricePerUnit\":0,\"quantityValue\":0,\"quantityUnit\":0,\"price\":0,\"warehouseId\":\"\",\"deliveryDate\":\"\",\"manufacturingDate\":\"2020-05-14\",\"expiryDate\":\"2020-05-31\",\"qualityCheck\":\"\",\"processDate\":\"\",\"orderId\":100}";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/materialstock/updatestock").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc).andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		System.out.println(m.getResponse().getContentAsString());
		
	}
	@Test
	public void checkproductorder() throws Exception
	{
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.get("/productstock/getOrder/400").contentType(MediaType.APPLICATION_JSON);
MvcResult m=mc.perform(rc).andDo(MockMvcResultHandlers.print()).andReturn();
System.out.println(m.getResponse());

	}
	

	@Test
	public void exitDate() throws Exception
	{
		
		String json="{\"name\":\"\",\"pricePerUnit\":0,\"quantityValue\":0,\"quantityUnit\":0,\"price\":0,\"warehouseId\":\"\",\"deliveryDate\":\"\",\"manufacturingDate\":\"\",\"expiryDate\":\"\",\"qualityCheck\":\"\",\"exitDate\":\"2020-05-08\",\"orderId\":400}";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/productstock/updateExitDate").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		//Assertions.assertEquals(m.get, "Exit Date Modified");
		System.out.println(m.getResponse().getContentAsString());
		
	}
	@Test
	public void updateproduct() throws Exception
	{
		
		String json="{\"name\":\"\",\"pricePerUnit\":0,\"quantityValue\":0,\"quantityUnit\":0,\"price\":0,\"warehouseId\":\"\",\"deliveryDate\":\"\",\"manufacturingDate\":\"2020-05-09\",\"expiryDate\":\"2020-05-11\",\"qualityCheck\":\"best\",\"exitDate\":\"\",\"orderId\":400}";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/productstock/updatestock").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		
		System.out.println(m.getResponse());
		
	}
	@Test
	public void logintest() throws Exception
	{
		String json="{\"username\":\"affi\",\"password\":\"affi09\" }";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/admin/login").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		
		System.out.println(m.getResponse());	
	}
	@Test
	public void forgottest() throws Exception
	{
		String json="{\"username\":\"affi\",\"password\":\"affi09\" }";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/admin/forgot").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		
		System.out.println(m.getResponse());	
	}
}
