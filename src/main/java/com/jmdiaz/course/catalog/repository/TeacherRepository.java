package com.jmdiaz.course.catalog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.jmdiaz.course.catalog.model.Teacher;

@Repository
public interface TeacherRepository {

	@Select("SELECT * FROM teacher")
	List<Teacher> getAllTeachers();
}
