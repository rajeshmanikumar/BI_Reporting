package com.stockinfo.ops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class StockInfoManagement {

	public static void main(String[] args) {
		try {
			//System.setProperty("spring.devtools.restart.enabled", "false");
			System.out.println("Starts");
			SpringApplication.run(StockInfoManagement.class, args);
			System.out.println("Ends");
		}
		catch(Exception e){
			System.out.println("Okay Error" +e.toString());
		}
		
	}

}
