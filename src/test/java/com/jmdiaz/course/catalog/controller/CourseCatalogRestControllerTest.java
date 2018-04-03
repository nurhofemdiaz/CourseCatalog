package com.jmdiaz.course.catalog.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jmdiaz.course.catalog.exception.GeneralException;
import com.jmdiaz.course.catalog.model.Course;
import com.jmdiaz.course.catalog.model.Teacher;
import com.jmdiaz.course.catalog.service.CourseCatalogService;
import com.jmdiaz.course.catalog.service.TeacherService;
import com.jmdiaz.course.catalog.utils.CourseLevel;

@RunWith(MockitoJUnitRunner.class)
public class CourseCatalogRestControllerTest {

	@InjectMocks
	private final CourseCatalogController restControllerTest = new CourseCatalogRestController();

	@Mock
	private CourseCatalogService mockCourseService;
	@Mock
	private TeacherService mockTeacherService;

	// @Before
	// public void setUp() {
	// restControllerTest
	//
	// mockTeacherService = mock(TeacherService.class);
	// mockCourseService = mock(CourseCatalogService.class);
	// }

	@Test
	public void testGetNumberOfPagesOK() throws Exception {
		// Precondition
		final int EXPECTED_NUMBER_OF_PAGES = -11111;
		when(mockCourseService.getNumberPages(anyInt())).thenReturn(EXPECTED_NUMBER_OF_PAGES);

		// Execution
		int result = restControllerTest.getNumberOfPages(EXPECTED_NUMBER_OF_PAGES);

		// Expected
		assertThat(result, is(EXPECTED_NUMBER_OF_PAGES));
	}

	@Test(expected = GeneralException.class)
	public void testGetNumberOfPagesKO() throws Exception {
		// Precondition
		final int EXPECTED_NUMBER_OF_PAGES = -11111;
		when(mockCourseService.getNumberPages(anyInt())).thenThrow(new Exception());

		// Execution
		restControllerTest.getNumberOfPages(EXPECTED_NUMBER_OF_PAGES);

		// Expected exception
	}

	@Test
	public void testGetAllTeachersOK() throws Exception {
		// Precondition
		Teacher[] array = { new Teacher(1, "name", "surname") };
		List<Teacher> EXPECTED_TEACHERS = Arrays.asList(array);
		when(mockTeacherService.getAllTeachers()).thenReturn(EXPECTED_TEACHERS);

		// Execution
		List<Teacher> result = restControllerTest.getAllTeachers();

		// Expected
		assertThat(result, is(EXPECTED_TEACHERS));
	}

	@Test(expected = GeneralException.class)
	public void testGetAllTeachersKO() throws Exception {
		// Precondition
		when(mockTeacherService.getAllTeachers()).thenThrow(new Exception());

		// Execution
		restControllerTest.getAllTeachers();

		// Expected
	}

	@Test
	public void testGetCourseLevel() throws GeneralException {
		// Precondition
		CourseLevel[] EXPECTED_LEVEL = CourseLevel.values();

		// Execution
		CourseLevel[] result = restControllerTest.getCourseLevels();

		// Expected
		assertThat(result, is(EXPECTED_LEVEL));
	}

	@Test
	public void testGetPageCoursesOrderedOK() throws Exception {
		// Precondition
		Course[] arrayCourse = { new Course(1, true, "title", 0, 10, new Teacher(1, "name", "surname")) };
		List<Course> EXPECTED_COURSES = Arrays.asList(arrayCourse);
		when(mockCourseService.getCoursesPage(anyInt(), anyInt(), anyBoolean())).thenReturn(EXPECTED_COURSES);

		// Execution
		List<Course> result = restControllerTest.getPageCoursesOrderered(111, 577, true);

		// Expected
		assertThat(result, is(EXPECTED_COURSES));
	}

	@Test(expected = GeneralException.class)
	public void testGetPageCoursesOrderedKO() throws Exception {
		// Precondition
		when(mockCourseService.getCoursesPage(anyInt(), anyInt(), anyBoolean())).thenThrow(new Exception());

		// Execution
		restControllerTest.getPageCoursesOrderered(111, 577, true);

		// Expected exception
	}

	@Test
	public void testAddCourse() throws Exception {
		// Precondition
		Course EXPECTED_COURSE = new Course(1, true, "title", 0, 10, new Teacher(1, "name", "surname"));
		Response EXPECTED_RESPONSE = Response.status(Response.Status.CREATED).build();
		doNothing().when(mockCourseService).addCourse(EXPECTED_COURSE);

		// Execution
		Response result = restControllerTest.addCourse(EXPECTED_COURSE);

		// Expected
		assertThat(result.getStatus(), is(EXPECTED_RESPONSE.getStatus()));
	}

	@Test(expected = GeneralException.class)
	public void testAddCourseKO() throws Exception {
		// Precondition
		Course EXPECTED_COURSE = new Course(1, true, "title", 0, 10, new Teacher(1, "name", "surname"));
		doThrow(new Exception()).when(mockCourseService).addCourse(EXPECTED_COURSE);

		// Execution
		restControllerTest.addCourse(EXPECTED_COURSE);

		// Expected exception
	}

}
