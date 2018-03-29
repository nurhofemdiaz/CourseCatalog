package com.jmdiaz.course.catalog.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CourseCatalogRestControllerTest {

	private final CourseCatalogRestController restController = new CourseCatalogRestController();
	
	@Test
	public void testGetNumberOfPagesKO() {
		Integer pages = restController.getNumberOfPages(-1);
		assertThat(pages,notNullValue());
		assertThat(pages,is(0));
	}
	
	@Test
	public void testGetNumberOfPagesOK() {
		Integer pages = restController.getNumberOfPages(5);
		assertThat(pages,notNullValue());
		assertThat(pages,is(0));
	}
	
}
