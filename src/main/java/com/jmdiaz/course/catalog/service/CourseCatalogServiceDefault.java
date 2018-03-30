package com.jmdiaz.course.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Page;
import com.jmdiaz.course.catalog.repository.CourseRepository;
import com.jmdiaz.course.catalog.utils.Order;

/**
 * Default implementation for course catalog service
 * @author kentaro
 *
 */
@Service
public class CourseCatalogServiceDefault implements CourseCatalogService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getCoursesPage(Page page) {
		return courseRepository.getAllActiveCourses(page.getNumberOfPage(), page.getRowSizeList(), Order.getOrder(page.isAscendingOrder()));
	}

	@Override
	public Integer getNumberPages(int numberRows) {
		return courseRepository.getPagesNumber(numberRows);
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.addCourse(course);
	}
	
}
