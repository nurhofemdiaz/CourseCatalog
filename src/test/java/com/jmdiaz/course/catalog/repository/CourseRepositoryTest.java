package com.jmdiaz.course.catalog.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmdiaz.course.catalog.config.PersistenceConfig;
import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.utils.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PersistenceConfig.class})
public class CourseRepositoryTest {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TeacherRepository teacherRepository;

	@Test
	public void testGetAllActiveCourses() {
		List<Course> courseList = courseRepository.getAllActiveCourses(3, 3, Order.getOrder(true));
		assertThat(courseList, hasItem(hasProperty("title", is("Novedades en Java 8"))));
	}
	
	@Test
	public void testCounterPages() {
		Integer pagesNumber = courseRepository.getPagesNumber(3);
		assertThat(pagesNumber, is(4));
	}
	
	@Test
	public void testInsert() {
		Course course = new Course();
		course.setEnable(false);
		course.setHours(42);
		course.setLevel(0);
		course.setTeacher(teacherRepository.getAllTeachers().get(0));
		course.setTitle("Prueba inactivo");
		courseRepository.addCourse(course);
	}
}