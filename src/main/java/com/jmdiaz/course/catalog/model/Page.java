package com.jmdiaz.course.catalog.model;

import java.util.Collection;

public class Page {
	private int numberOfPage;
	private int rowSizeList;
	private boolean ascendingOrder;
	private String orderingField;
	private Collection<Course> courseList;
	
	public Page(int numberOfPage, int rowSizeList, boolean ascendingOrder, String orderingField, Collection<Course> courseList) {
		super();
		this.numberOfPage = numberOfPage;
		this.rowSizeList = rowSizeList;
		this.ascendingOrder = ascendingOrder;
		this.orderingField = orderingField;
		this.courseList = courseList;
	}
	
	public int getNumberOfPage() {
		return numberOfPage;
	}
	
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	
	public int getRowSizeList() {
		return rowSizeList;
	}
	
	public void setRowSizeList(int rowSizeList) {
		this.rowSizeList = rowSizeList;
	}
	
	public boolean isAscendingOrder() {
		return ascendingOrder;
	}
	
	public void setAscendingOrder(boolean ascendingOrder) {
		this.ascendingOrder = ascendingOrder;
	}
	
	public String getOrderingField() {
		return orderingField;
	}
	
	public void setOrderingField(String orderingField) {
		this.orderingField = orderingField;
	}
	
	public Collection<Course> getCourseList() {
		return courseList;
	}
	
	public void setCourseList(Collection<Course> courseList) {
		this.courseList = courseList;
	}
}
