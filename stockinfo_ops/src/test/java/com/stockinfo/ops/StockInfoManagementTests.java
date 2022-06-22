package com.stockinfo.ops;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;

import com.stockinfo.ops.controller.StocksInfoController;
import com.stockinfo.ops.model.StocksInfo;
import com.stockinfo.ops.repository.StocksInfoRepository;

//@SpringBootTest
//@WebMvcTest(StocksInfoController.class)
@SpringBootTest
@AutoConfigureMockMvc
class StockInfoManagementTests {

	@Autowired
	StocksInfoRepository stocksInfoRepository;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllStocks() throws Exception {

		Timestamp sqlTimestamp1 = Timestamp.valueOf("2022-06-18 17:00:45.000");
		StocksInfo RECORD_1 = new StocksInfo();
		RECORD_1.setStock_num(1L);
		RECORD_1.setStock_id("atl");
		RECORD_1.setStock_name("aitel");
		RECORD_1.setStock_price(20.66);
		RECORD_1.setStock_lastupdatedon(sqlTimestamp1);
		Timestamp sqlTimestamp2 = Timestamp.valueOf("2022-06-18 18:30:22.000");
		StocksInfo RECORD_2 = new StocksInfo();
		RECORD_2.setStock_num(3L);
		RECORD_2.setStock_id("klm");
		RECORD_2.setStock_name("klm flight");
		RECORD_2.setStock_price(40.77);
		RECORD_2.setStock_lastupdatedon(sqlTimestamp2);
		Timestamp sqlTimestamp3 = Timestamp.valueOf("2022-06-18 19:33:11.000");
		StocksInfo RECORD_3 = new StocksInfo();
		RECORD_3.setStock_num(4L);
		RECORD_3.setStock_id("eth");
		RECORD_3.setStock_name("ethiad flight");
		RECORD_3.setStock_price(102.94);
		RECORD_3.setStock_lastupdatedon(sqlTimestamp3);
		
		List<StocksInfo> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
		
		//Mockito.when(stocksInfoRepository.findAll()).thenReturn(records);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/api/stocks")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(jsonPath("$", hasSize(5)));
				//.andExpect(jsonPath("$[0].stock_name", is("ethiad flight")));
	}

}
