package com.jmdiaz.course.catalog.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.commons.lang3.StringUtils;

import com.jmdiaz.course.catalog.model.Course;

/**
 * Interface for course validators
 * 
 * @author kentaro
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCourse.Validator.class)
public @interface ValidCourse {
	String message() default "{javax.validation.constraints.InvalidCourse.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Courses validator
	 * 
	 * @author kentaro
	 *
	 */
	public class Validator implements ConstraintValidator<ValidCourse, Course> {

		@Override
		public void initialize(final ValidCourse hasId) {
		}

		@Override
		public boolean isValid(final Course course, final ConstraintValidatorContext constraintValidatorContext) {

			// course object is mandatory
			if (course == null) {
				return false;
			}

			// course title is mandatory
			if (StringUtils.isEmpty(course.getTitle())) {
				return false;
			}

			// Range of hours it is between 0 and 99
			if (course.getHours() < 0 || course.getHours() > 99) {
				return false;
			}

			// Teacher is mandatory
			if (course.getTeacher() == null || course.getTeacher().getId() == 0) {
				return false;
			}

			// Valid object
			return true;
		}
	}
}