package com.jmdiaz.course.catalog.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jmdiaz.course.catalog.controller.CourseCatalogRestController;
import com.jmdiaz.course.catalog.exception.CustomGeneralExceptionMapper;
import com.jmdiaz.course.catalog.exception.CustomInvalidParametersMapper;
import com.jmdiaz.course.catalog.exception.CustomValidationExceptionMapper;

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
		registerClasses(CourseCatalogRestController.class, CorsConfig.class, CustomInvalidParametersMapper.class,
				CustomGeneralExceptionMapper.class, CustomValidationExceptionMapper.class);
	}

}
