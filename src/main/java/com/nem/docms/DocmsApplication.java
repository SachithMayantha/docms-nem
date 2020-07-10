package com.nem.docms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DocmsApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DocmsApplication.class, args);
	}
	
	@Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(DocmsApplication.class);
	   }
}
