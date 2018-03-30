package com.jmdiaz.course.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main class to deploy a packing war on a external servlets container. Extends ServletInitializer of Springboot
 * @author kentaro
 *
 */
@SpringBootApplication
public class CourseCatalogApplication extends SpringBootServletInitializer {
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	 	return application.sources(CourseCatalogApplication.class);
	 }
	 
	 public static void main(String[] args) throws Exception {
	 	SpringApplication.run(CourseCatalogApplication.class, args);
	 }

}
