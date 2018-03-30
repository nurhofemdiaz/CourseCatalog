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
 * @author kentaro
 *
 */
@Component
@Path("/course")
public class CourseCatalogRestController {
	
	@Autowired
	private CourseCatalogService courseService;
	
	@Autowired
	private TeacherService teacherService;
	
	
	/*
	 * LAYER COURSE CATALOG LIST
	 */
	
	/**
	 * Get the pages number for a input parameter size of rows 
	 * @param courseSizeList	Number of row per page
	 * @return Pages number
	 */
	@GET
    @Produces("application/json")
	@Path("/pages/size/{courseSizeList}")
    public Integer getNumberOfPages( @PathParam("courseSizeList") int courseSizeList) {
		return courseService.getNumberPages(courseSizeList);
    }
	
	/**
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
    												   @PathParam("courseSizeList") int courseSizeList, 
    												   @PathParam("order") boolean ascendingOrder) {
        return courseService.getCoursesPage(new Page(numberOfPage,courseSizeList,ascendingOrder));
    }
	
	/*
	 * LAYER ADD COURSE TO CATALOG LIST
	 */
	/**
	 * 
	 * @return
	 */
	@GET
    @Produces("application/json")
	@Path("/teachers")
    public Collection<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
	
	/**
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
	 * 
	 * @param course
	 */
	@POST
    @Consumes("application/json")
    public void addBook(Course course) {
		courseService.addCourse(course);
    }
}
