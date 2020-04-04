package com.github.vshtishi;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
	private static final long serialVersionUID=1L;
	private String name;
	private int id;

	public Person() {

	}

	public Person(String name, int id) {
		if (name == null || name.trim().length() == 0)
			throw new IllegalArgumentException("Name is required");
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Name is required");
		}
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("Id cannot be a negative nr");
		}
		this.id = id;
	}

	// Overriding methods defined in Object
	@Override
	public String toString() {
		return "Name: " + name;
	}

	@Override
	public int hashCode() {
		return 7 * 13 + id;
	}

	// The compareTo() and equals() methods should be consistent
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person otherPerson = (Person) obj;
		return this.id == otherPerson.id;
	}

	/*
	 * The compareTo() method must return: 0 when the current object is equal to
	 * the argument a nr less than zero when the current object is smaller than
	 * the argument a nr greater than zero when the current object is larger
	 * than the argument
	 */
	public int compareTo(Person person) {
		return id - person.id;
	}

}
