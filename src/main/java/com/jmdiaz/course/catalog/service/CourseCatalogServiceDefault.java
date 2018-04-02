package com.jmdiaz.course.catalog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.repository.CourseRepository;
import com.jmdiaz.course.catalog.utils.Order;

/**
 * Default implementation for course catalog service
 * 
 * @author kentaro
 *
 */
@Service
public class CourseCatalogServiceDefault implements CourseCatalogService {

	private static final Logger logger = LoggerFactory.getLogger(CourseCatalogServiceDefault.class);

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getCoursesPage(int numberOfPage, int courseSizeList, boolean ascendingOrder) {
		logger.debug("#### Course catalog service. Executing method getCoursesPage");
		return courseRepository.getAllActiveCourses(numberOfPage, courseSizeList, Order.getOrder(ascendingOrder));
	}

	@Override
	public Integer getNumberPages(int numberRows) {
		logger.debug("#### Course catalog service. Executing method getNumberPages");
		return courseRepository.getPagesNumber(numberRows);
	}

	@Override
	public void addCourse(Course course) {
		logger.debug("#### Course catalog service. Executing method addCourse");
		courseRepository.addCourse(course);
	}

}
