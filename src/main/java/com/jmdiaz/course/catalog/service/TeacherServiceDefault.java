package com.jmdiaz.course.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.repository.TeacherRepository;

/**
 * Default implementation for teacher of courses service
 * 
 * @author kentaro
 *
 */
@Service
public class TeacherServiceDefault implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.getAllTeachers();
	}

}
