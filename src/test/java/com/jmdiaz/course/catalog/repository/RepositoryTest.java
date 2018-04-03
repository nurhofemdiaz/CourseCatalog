package com.jmdiaz.course.catalog.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmdiaz.course.catalog.configtest.PersistenceTestConfig;
import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PersistenceTestConfig.class })
public class RepositoryTest {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	SqlSession sqlSession;

	@Before
	public void setUp() {
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void tearDown() {
		sqlSession.close();
	}

	@Test
	public void testGetPagesNumber() {
		// Precondition
		int RESULT_EXPECTED = 1;
		CourseRepository mapper = sqlSession.getMapper(CourseRepository.class);

		// Execution
		int result = mapper.getPagesNumber(12);

		// Expected
		assertThat(result, is(RESULT_EXPECTED));
	}

	@Test
	public void testGetAllTeachers() {
		// Precondition
		Teacher EXPECTED_RESULT = new Teacher(5, "Stephen", "Hawking");
		TeacherRepository mapper = sqlSession.getMapper(TeacherRepository.class);

		// Execution
		List<Teacher> result = mapper.getAllTeachers();

		// Expected
		assertThat(result, hasItem(EXPECTED_RESULT));
	}

	@Test
	public void testInsert() {
		// Precondition
		Course EXPECTED_RESULT = new Course(1, false, "title", 1, 15, new Teacher(1, "name", "surname"));
		CourseRepository mapper = sqlSession.getMapper(CourseRepository.class);

		// Execution
		mapper.addCourse(EXPECTED_RESULT);
		
		// Expected
	}
}