package com.jmdiaz.course.catalog.model;

public enum CourseLevel {
	BASIC("Básico",0), 
	INTERMEDIATE("Intermedio",1),
	ADVANCED("Avanzado",2);
	
	private String name;
	private int level;
	
	private CourseLevel(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
