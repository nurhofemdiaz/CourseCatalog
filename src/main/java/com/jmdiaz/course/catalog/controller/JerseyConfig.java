package com.jmdiaz.course.catalog.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jmdiaz.course.catalog.config.CorsConfig;

/**
 * Configuration class for Jersey Resources
 * 
 * @author kentaro
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	/*
	 * Registration resources
	 */
	public JerseyConfig() {
		registerClasses(CourseCatalogRestController.class, CorsConfig.class);
	}

}
