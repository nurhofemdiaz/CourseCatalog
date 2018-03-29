package com.jmdiaz.course.catalog.service;

import java.util.Collection;

import com.jmdiaz.course.catalog.model.Course;

public interface CourseCatalogService {
	
	public Collection<Course> getCoursesPage(int numberPage, int numberRows, String sortNameField, boolean ascendingOrdered);
	
	public Integer getNumberPages(int numberRows);
	
	public void addCourse(Course course);
	
}
