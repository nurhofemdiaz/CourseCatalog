package com.jmdiaz.course.catalog.service;

import java.util.Collection;

import com.jmdiaz.course.catalog.model.Course;

public class TeacherServiceDefault implements CourseCatalogService {

	@Override
	public Collection<Course> getCoursesPage(int numberPage, int numberRows, String sortNameField,
			boolean ascendingOrdered) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getNumberPages(int numberRows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub

	}

}
