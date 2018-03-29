package com.jmdiaz.course.catalog.model;

public class Course {
	private boolean enable;
	private String title;
	private CourseLevel level;
	private int hours;
	private Teacher teacher;
	
	public Course(boolean enable, String title, CourseLevel level, int hours, Teacher teacher) {
		super();
		this.enable = enable;
		this.title = title;
		this.level = level;
		this.hours = hours;
		this.teacher = teacher;
	}

	public boolean isEnable() {
		return enable;
	}
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public CourseLevel getLevel() {
		return level;
	}
	
	public void setLevel(CourseLevel level) {
		this.level = level;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
