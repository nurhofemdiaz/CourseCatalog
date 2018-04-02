package com.jmdiaz.course.catalog.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Page;
import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.service.CourseCatalogService;
import com.jmdiaz.course.catalog.service.TeacherService;
import com.jmdiaz.course.catalog.utils.CourseLevel;

/**
 * Rest controller
 * 
 * @author kentaro
 *
 */
@Component
@Path("/course")
public class CourseCatalogRestController implements CourseCatalogController {

	@Autowired
	private CourseCatalogService courseService;

	@Autowired
	private TeacherService teacherService;

	/*
	 * LAYER COURSE CATALOG LIST
	 */

	/**
	 * Get the pages number for a input parameter size of rows
	 * 
	 * @param courseSizeList
	 *            Number of row per page
	 * @return Pages number
	 */
	@GET
	@Produces("application/json")
	@Path("/page/size/{courseSizeList}")
	public Integer getNumberOfPages(@PathParam("courseSizeList") int courseSizeList) {
		return courseService.getNumberPages(courseSizeList);
	}

	/**
	 * This method return all active course for a page per number of rows to show
	 * ordered
	 * 
	 * @param numberOfPage
	 * @param courseSizeList
	 * @param order
	 * @return
	 */
	@GET
	@Produces("application/json")
	@Path("/page/{numberOfPage}/size/{courseSizeList}/order/{order}")
	public List<Course> getPageCoursesOrderered(@PathParam("numberOfPage") int numberOfPage,
			@PathParam("courseSizeList") int courseSizeList, @PathParam("order") boolean ascendingOrder) {
		return courseService.getCoursesPage(new Page(numberOfPage, courseSizeList, ascendingOrder));
	}

	/*
	 * LAYER ADD COURSE TO CATALOG LIST
	 */
	/**
	 * Get all course teachers available
	 * 
	 * @return All teachers list
	 */
	@GET
	@Produces("application/json")
	@Path("/teachers")
	public Collection<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	/**
	 * This method return all course levels available
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	@Path("/levels")
	public CourseLevel[] getCourseLevels() {
		return CourseLevel.values();
	}

	/**
	 * This method add a new course
	 * 
	 * @param course
	 */
	@POST
	@Consumes("application/json")
	@Path("/add")
	public void addCourse(Course course) {
		courseService.addCourse(course);
	}
}
