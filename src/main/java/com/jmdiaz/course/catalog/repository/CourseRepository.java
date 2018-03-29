package com.jmdiaz.course.catalog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.jmdiaz.course.catalog.model.Course;

@Repository
public interface CourseRepository {
	
	@Select("SELECT * FROM course c, teacher t "
			+ "WHERE c.teacher = t.id "
				+ "AND c.enable = true "
			+ "ORDER BY c.title ${order} "
			+ "LIMIT #{rowSizeList}"
			+ "OFFSET (#{rowSizeList} * (#{numberOfPage}))"
	)
	List<Course> getAllActiveCourses(@Param("numberOfPage") int numberOfPage, 
									@Param("rowSizeList") int rowSizeList, 
									@Param("order") String order);
	
	@Select("SELECT count(*)/#{rowSizeList} FROM course c WHERE c.enable = true")
	Integer getPagesNumber(@Param("rowSizeList") int rowSizeList);
	
	@Insert("INSERT INTO course (title, enable, level, hours, teacher) "
			+ "VALUES (#{title}, #{enable}, #{level}, #{hours}, #{teacher.id})"
	)
	@Options(useGeneratedKeys=true,keyProperty="id")
	void addCourse(Course course);
	
}
