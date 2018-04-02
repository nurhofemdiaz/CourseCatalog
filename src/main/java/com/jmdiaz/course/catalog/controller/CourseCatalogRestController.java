package com.jmdiaz.course.catalog.controller;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jmdiaz.course.catalog.exception.GeneralException;
import com.jmdiaz.course.catalog.exception.InvalidParametersException;
import com.jmdiaz.course.catalog.model.Course;
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

	private static final Logger logger = LoggerFactory.getLogger(CourseCatalogRestController.class);

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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/page/size/{courseSizeList}")
	public Integer getNumberOfPages(@PathParam("courseSizeList") int courseSizeList)
			throws GeneralException, InvalidParametersException {
		try {
			logger.debug("#### Jersey rest controller. Executing method getNumberOfPages");
			return courseService.getNumberPages(courseSizeList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new GeneralException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
		}
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/page/{numberOfPage}/size/{courseSizeList}/order/{order}")
	public List<Course> getPageCoursesOrderered(@PathParam("numberOfPage") int numberOfPage,
			@PathParam("courseSizeList") int courseSizeList, @PathParam("order") boolean ascendingOrder)
			throws GeneralException, InvalidParametersException {
		try {
			logger.debug("#### Jersey rest controller. Executing method getPageCoursesOrderered");
			return courseService.getCoursesPage(numberOfPage, courseSizeList, ascendingOrder);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new GeneralException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
		}
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/teachers")
	public Collection<Teacher> getAllTeachers() throws GeneralException {
		try {
			logger.debug("#### Jersey rest controller. Executing method getAllTeachers");
			return teacherService.getAllTeachers();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new GeneralException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
		}
	}

	/**
	 * This method return all course levels available
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/levels")
	public CourseLevel[] getCourseLevels() throws GeneralException {
		try {
			logger.debug("#### Jersey rest controller. Executing method getCourseLevels");
			return CourseLevel.values();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new GeneralException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
		}
	}

	/**
	 * This method add a new course
	 * 
	 * @param course
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addCourse(Course course) throws GeneralException, InvalidParametersException {
		try {
			logger.debug("#### Jersey rest controller. Executing method addCourse");
			courseService.addCourse(course);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new GeneralException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage());
		}
	}
}
