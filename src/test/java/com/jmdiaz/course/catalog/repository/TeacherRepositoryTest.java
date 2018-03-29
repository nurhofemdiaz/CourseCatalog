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
import com.jmdiaz.course.catalog.model.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PersistenceConfig.class})
public class TeacherRepositoryTest {
	@Autowired
	TeacherRepository teacherRepository;

	@Test
	public void testGetAllTeachers() {
		List<Teacher> teacherList = teacherRepository.getAllTeachers();
		assertThat(teacherList, hasItem(hasProperty("name", is("José Manuel"))));
	}
}
