package com.jmdiaz.course.catalog.utils;

public enum CourseLevel {
	BASIC, 
	INTERMEDIATE,
	ADVANCED;
	
	public static CourseLevel getLevel(int level) {
		return CourseLevel.values()[level];
	}
}
