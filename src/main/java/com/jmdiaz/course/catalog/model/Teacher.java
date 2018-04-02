package com.jmdiaz.course.catalog.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Teacher POJO
 * 
 * @author kentaro
 *
 */
public class Teacher {
	private int id;
	private String name;
	private String surname;

	public Teacher() {
	}

	public Teacher(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new org.apache.commons.lang3.builder.ToStringBuilder(this).append("id", id).append("name", name)
				.append("surname", surname).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).append(surname).toHashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Teacher course = (Teacher) o;

		return new EqualsBuilder().append(id, course.id).append(name, course.name).append(surname, course.surname)
				.isEquals();
	}
}
