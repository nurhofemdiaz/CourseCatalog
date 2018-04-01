package com.jmdiaz.course.catalog.model;

import com.jmdiaz.course.catalog.utils.CourseLevel;

/**
 * Course POJO
 * 
 * @author kentaro
 *
 */
public class Course {
	private int id;
	private boolean enable;
	private String title;
	private CourseLevel level;
	private int hours;
	private Teacher teacher;

	public Course() {
	}

	public Course(int id, boolean enable, String title, int level, int hours, Teacher teacher) {
		super();
		this.id = id;
		this.enable = enable;
		this.title = title;
		this.level = CourseLevel.getLevel(level);
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

	public int getOrdinal() {
		return level.ordinal();
	}

	public void setLevel(int level) {
		this.level = CourseLevel.getLevel(level);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
