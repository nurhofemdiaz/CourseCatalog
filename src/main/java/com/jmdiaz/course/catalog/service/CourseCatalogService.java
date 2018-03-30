package com.jmdiaz.course.catalog.service;

import java.util.List;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Page;

/**
 * Interface for services implementation of courses catalog
 * @author kentaro
 *
 */
public interface CourseCatalogService {
	
	/**
	 * Returns a active courses list for page requested 
	 * @param page The page parameters (size of page, current page, order of filtering
	 * @return
	 */
	public List<Course> getCoursesPage(Page page);
	
	/**
	 * Returns a number of pages stored for a number of rows
	 * @param numberRows
	 * @return
	 */
	public Integer getNumberPages(int numberRows);
	
	/**
	 * Add a new course to courses catalog
	 * @param course
	 */
	public void addCourse(Course course);
	
}
