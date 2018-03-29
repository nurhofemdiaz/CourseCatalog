package com.jmdiaz.course.catalog.utils;

public enum Order {
	DESC("DESC"), 
	ASC("ASC");
	
	private String name;
	
	private Order(String name) {
		this.name = name;
	}
	
	public static String getOrder(Boolean ordinal) {
		return values()[ordinal? 1 : 0].getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
