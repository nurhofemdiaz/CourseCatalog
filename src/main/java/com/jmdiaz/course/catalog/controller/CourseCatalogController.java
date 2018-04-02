package com.jmdiaz.course.catalog.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.Response;

import com.jmdiaz.course.catalog.exception.GeneralException;
import com.jmdiaz.course.catalog.exception.InvalidParametersException;
import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.utils.CourseLevel;

public interface CourseCatalogController {

	/**
	 * Get the pages number for a input parameter size of rows
	 * 
	 * @param courseSizeList
	 *            Number of row per page
	 * @return Pages number
	 */
	public Integer getNumberOfPages(int courseSizeList) throws GeneralException, InvalidParametersException;

	/**
	 * This method return all active course for a page per number of rows to show
	 * ordered
	 * 
	 * @param numberOfPage
	 * @param courseSizeList
	 * @param order
	 * @return course List
	 */
	public List<Course> getPageCoursesOrderered(int numberOfPage, int courseSizeList, boolean ascendingOrder)
			throws GeneralException, InvalidParametersException;

	/**
	 * Get all course teachers available
	 * 
	 * @return All teachers list
	 */
	public Collection<Teacher> getAllTeachers() throws GeneralException;

	/**
	 * This method return all course levels available
	 * 
	 * @return
	 */
	public CourseLevel[] getCourseLevels() throws GeneralException;

	/**
	 * This method add a new course
	 * 
	 * @param course
	 * @ return Response HTTP
	 */
	public Response addCourse(Course course) throws GeneralException, InvalidParametersException;
}
