package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.anurag.inventorymanagementsystem.InventoryManagementSystemApplication;

import com.cg.anurag.inventorymanagementsystem.service.ProductStockService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=InventoryManagementSystemApplication.class)
@AutoConfigureMockMvc
public class InventoryManagementSystemApplicationTests {

	@Autowired
	MockMvc mc;
	@MockBean
	ProductStockService ps;
	


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
	}