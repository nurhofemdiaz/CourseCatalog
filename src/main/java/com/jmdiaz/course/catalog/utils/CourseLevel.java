package com.jmdiaz.course.catalog.utils;

/**
 * Enumeration of course levels
 * 
 * @author kentaro
 *
 */
public enum CourseLevel {
	BASIC, INTERMEDIATE, ADVANCED;

	/**
	 * Return a level in ordinal input parameters
	 * 
	 * @param level
	 *            Ordinal level
	 * @return Course level
	 */
	public static CourseLevel getLevel(int level) {
		return CourseLevel.values()[level];
	}
}
