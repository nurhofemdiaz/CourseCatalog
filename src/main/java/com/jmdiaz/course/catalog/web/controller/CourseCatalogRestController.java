package com.jmdiaz.course.catalog.web.controller;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Page;
import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.utils.CourseLevel;

@Component
@Path("/course")
public class CourseCatalogRestController {
	/*
	 * LAYER COURSE CATALOG LIST
	 */
	
	/**
	 * 
	 * @param courseSizeList
	 * @return
	 */
	@GET
    @Produces("application/json")
	@Path("/pages/size/{courseSizeList}")
    public Integer getNumberOfPages( @PathParam("courseSizeList") int courseSizeList) {
//      return service.getAll();
        return null;
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
    public Page getPageCoursesOrderered(@PathParam("numberOfPage") int numberOfPage, 
    												   @PathParam("courseSizeList") int courseSizeList, 
    												   @PathParam("order") boolean ascendingOrder) {
//        return service.getAll();
        return null;
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
//        return service.getAll();
        return null;
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
//        service.add(course);
    }
}
