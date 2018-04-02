package com.jmdiaz.course.catalog.service;

import java.util.List;

import com.jmdiaz.course.catalog.model.Course;

/**
 * Interface for services implementation of courses catalog
 * 
 * @author kentaro
 *
 */
public interface CourseCatalogService {

	/**
	 * Returns a active courses list for page requested
	 * 
	 * @param numberOfPage
	 * @param courseSizeList
	 * @param ascendingOrder
	 * @return List or courses
	 */
	public List<Course> getCoursesPage(int numberOfPage, int courseSizeList, boolean ascendingOrder);

	/**
	 * Returns a number of pages stored for a number of rows
	 * 
	 * @param numberRows
	 * @return
	 */
	public Integer getNumberPages(int numberRows);

	/**
	 * Add a new course to courses catalog
	 * 
	 * @param course
	 */
	public void addCourse(Course course);

}
