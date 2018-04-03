package com.jmdiaz.course.catalog.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.core.Response;

import com.jmdiaz.course.catalog.exception.GeneralException;
import com.jmdiaz.course.catalog.exception.InvalidParametersException;
import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.utils.CourseLevel;
import com.jmdiaz.course.catalog.validator.ValidCourse;

public interface CourseCatalogController {

	/**
	 * Get the pages number for a input parameter size of rows
	 * 
	 * @param courseSizeList
	 *            Number of row per page
	 * @return Pages number
	 */
	public Integer getNumberOfPages(@Min(1) @Max(20) int courseSizeList)
			throws GeneralException, InvalidParametersException;

	/**
	 * This method return all active course for a page per number of rows to show
	 * ordered
	 * 
	 * @param numberOfPage
	 * @param courseSizeList
	 * @param order
	 * @return course List
	 */
	public List<Course> getPageCoursesOrderered(@Min(0) @Max(1000) int numberOfPage,
			@Min(1) @Max(20) int courseSizeList, boolean ascendingOrder)
			throws GeneralException, InvalidParametersException;

	/**
	 * Get all course teachers available
	 * 
	 * @return All teachers list
	 */
	public List<Teacher> getAllTeachers() throws GeneralException;

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
	public Response addCourse(@ValidCourse Course course) throws GeneralException, InvalidParametersException;
}
