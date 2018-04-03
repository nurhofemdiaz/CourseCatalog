package com.jmdiaz.course.catalog.service;

import java.util.List;

import com.jmdiaz.course.catalog.model.Teacher;

/**
 * Interface for services implementation of teachers of courses
 * 
 * @author kentaro
 *
 */
public interface TeacherService {

	/**
	 * This method return a list with all teachers of courses
	 * 
	 * @return
	 */
	public List<Teacher> getAllTeachers() throws Exception;

}
