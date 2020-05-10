package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertThat;

import org.junit.Test;
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

import com.cg.anurag.inventorymanagementsystem.service.AdminService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=InventoryManagementSystemApplication.class)
@AutoConfigureMockMvc
public class InventoryManagementSystemApplicationTests {

	@Autowired
	MockMvc mc;
	
	@MockBean
	AdminService admin;
	
	
	@Test
	public void logintest() throws Exception
	{
		String json="{\"username\":\"affi\",\"password\":\"affi\" }";
		MockHttpServletRequestBuilder rc=MockMvcRequestBuilders.put("/admin/login").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json);
		MvcResult m=mc.perform(rc)
		.andReturn();
		
		System.out.println(m.getResponse());	
	}
}