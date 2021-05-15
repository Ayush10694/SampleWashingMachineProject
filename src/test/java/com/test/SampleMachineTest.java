package com.test;

import static org.junit.Assert.assertThat;

import java.awt.PageAttributes.MediaType;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Model.WashingMachine;
import com.Service.SampleMachineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleMachineTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SampleMachineService sampleService;
	
	@Test
	public void testGetMachineByID() throws Exception
	{
		Optional<WashingMachine> obj = null;
		obj.get().setId(3);
		obj.get().setName("Samsung");
		obj.get().setYear("2015");
		obj.get().setColor("Red");
		
		Mockito.when(sampleService.getSpecificMachine(Mockito.anyInt())).thenReturn(obj);
		
		String uri = "/machine/3";
		RequestBuilder req = MockMvcRequestBuilders.get(uri).accept(org.springframework.http.MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(req).andReturn();
		String expOut= this.mapToJson(obj);
		String out = result.getResponse().getContentAsString();
		//assertThat(out);
	
	}
	private String mapToJson(Object obj) throws JsonProcessingException
	{
		ObjectMapper obj1 = new ObjectMapper();
		return obj1.writeValueAsString(obj);
	}
}
