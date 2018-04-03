package com.jmdiaz.course.catalog.validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Teacher;

@RunWith(MockitoJUnitRunner.class)
public class ValidCourseTest {
	
	@Mock
	private ConstraintValidatorContext context;

	@InjectMocks
	private ValidCourse.Validator courseValidator = new ValidCourse.Validator();

	@Test
	public void testValidatorOK() {
		// Precondition
		boolean EXPECTED_RESULT = true;
		Course course = new Course(1, true, "title", 1, 1, new Teacher(1, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOTitle() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, "", 1, 1, new Teacher(1, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOTitleNull() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, null, 1, 1, new Teacher(1, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOHours() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, "title", 1, -1, new Teacher(1, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOHoursRange() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, "title", 1,1000, new Teacher(1, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOTeacher() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, "title", 1,1, new Teacher(0, "name", "surname"));

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}
	
	@Test
	public void testValidatorKOTeacherNull() {
		// Precondition
		boolean EXPECTED_RESULT = false;
		Course course = new Course(1, true, "title", 1,1, null);

		// Execution
		boolean result = courseValidator.isValid(course, context);

		// Expected
		assertThat(result, is(EXPECTED_RESULT));
	}

}