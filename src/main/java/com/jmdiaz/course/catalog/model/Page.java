package com.jmdiaz.course.catalog.model;

/**
 * Page POJO
 * 
 * @author kentaro
 *
 */
public class Page {
	private int numberOfPage;
	private int rowSizeList;
	private boolean ascendingOrder;

	public Page() {
	}

	public Page(int numberOfPage, int rowSizeList, boolean ascendingOrder) {
		super();
		this.numberOfPage = numberOfPage;
		this.rowSizeList = rowSizeList;
		this.ascendingOrder = ascendingOrder;
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
}
