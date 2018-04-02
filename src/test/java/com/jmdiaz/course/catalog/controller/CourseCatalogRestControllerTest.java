package com.jmdiaz.course.catalog.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.jmdiaz.course.catalog.service.CourseCatalogService;
import com.jmdiaz.course.catalog.service.TeacherService;

@RunWith(MockitoJUnitRunner.class)
public class CourseCatalogRestControllerTest {
	
//	@InjectMocks
//	private CourseCatalogRestController classUnderTest;
//	
//	@Mock
//	private CourseCatalogService mockCourseService;
//	@Mock
//	private TeacherService mockTeacherService;
	
//	@Before
//	public void setUp() {
//		classUnderTest = new CourseCatalogRestController();
//		
//		mockTeacherService = mock(TeacherService.class);
//		mockCourseService = mock(CourseCatalogService.class);
//	}

//	private final CourseCatalogRestController restController = new CourseCatalogRestController();
	
	@Test
	public void testGetNumberOfPagesKO() {
//		Integer pages = restController.getNumberOfPages(-1);
//		assertThat(pages,notNullValue());
//		assertThat(pages,is(0));
	}
	
	@Test
	public void testGetNumberOfPagesOK() {
//		Integer pages = restController.getNumberOfPages(5);
//		assertThat(pages,notNullValue());
//		assertThat(pages,is(0));
	}
	
	@Test
	public void givenValidNumberOfPagesReturnedWhenGetNumberOfPagesThenReturnTheSameNumber() {
		// Given
//		final int EXPECTED_NUMBER_OF_PAGES = 66;
//		when(mockCourseService.getNumberPages(anyInt())).thenReturn(EXPECTED_NUMBER_OF_PAGES);
//		//doReturn(EXPECTED_NUMBER_OF_PAGES).when(mockCourseService.getNumberPages(anyInt()));
//		
//		// When
//		int result = classUnderTest.getNumberOfPages(876);
//		
//		// Then
//		assertThat(result, is(EXPECTED_NUMBER_OF_PAGES));
	}
	
}
