package com.icims.customer.wizard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApp extends SpringBootServletInitializer implements CommandLineRunner {
   
   
	@Autowired
	JdbcTemplate jdbcTemplate;

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(MainApp.class);
   }
   
   
	@Override
	public void run(String... strings) throws Exception {
	
		/*
		String query = "select * from Offer where OfferId = 1";
		    	List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		    	for (Map row : rows) {
		    		System.out.println(row.get("OfferId"));
		    		System.out.println(row.get("SubmittalId"));
		    		System.out.println(row.get("TemplateId"));
			    }
		*/        
	}
	
	public static void main(String[] args) {
	      SpringApplication.run(MainApp.class, args);
	   }
	
}
