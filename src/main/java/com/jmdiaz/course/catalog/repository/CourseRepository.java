package com.jmdiaz.course.catalog.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.jmdiaz.course.catalog.model.Course;

/**
 * Mapper SQL for Course Repository 
 * @author kentaro
 */
@Repository
public interface CourseRepository {
	
	/**
	 * Select all actives courses catalog with pagination
	 * @param numberOfPage	Current page number
	 * @param rowSizeList	Size of rows per page
	 * @param order			Possible values 'ASC' or 'DESC'
	 * @return Page with list of course
	 */
//	@Select("SELECT * FROM course c, teacher t "
//			+ "WHERE c.teacher = t.id "
//				+ "AND c.enable = true "
//			+ "ORDER BY c.title ${order} "
//			+ "LIMIT #{rowSizeList}"
//			+ "OFFSET (#{rowSizeList} * (#{numberOfPage}))"
//	)
	List<Course> getAllActiveCourses(@Param("numberOfPage") int numberOfPage, 
									@Param("rowSizeList") int rowSizeList, 
									@Param("order") String order);
	
	/**
	 * Page counter by row size page
	 * @param rowSizeList	Size of rows per page
	 * @return Number of pages
	 */
	@Select("SELECT count(*)/#{rowSizeList} FROM course c WHERE c.enable = true")
	Integer getPagesNumber(@Param("rowSizeList") int rowSizeList);
	
	/**
	 * Insert a new course on courses catalog wit auto-incremental id
	 * @param course	new course
	 */
	@Insert("INSERT INTO course (title, enable, level, hours, teacher) "
			+ "VALUES (#{title}, #{enable}, #{ordinal}, #{hours}, #{teacher.id})"
	)
	@Options(useGeneratedKeys=true,keyProperty="id")
	void addCourse(Course course);
	
}
