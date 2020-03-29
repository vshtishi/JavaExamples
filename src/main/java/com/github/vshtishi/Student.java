package com.github.vshtishi;

import java.util.*;

//Creating an Immutable Class
public final class Student {

	private final String name;
	private final int student_id;
	private final List<Integer> grades;

	public Student(String name, int student_id, List<Integer> grades) {
		if (name == null || name.trim().length() == 0)
			throw new IllegalArgumentException("Name is required");
		this.name = name;
		this.student_id = student_id;
		if (grades == null)
			throw new RuntimeException("Grades are required");
		this.grades = new ArrayList<Integer>(grades);
	}

	public String getName() {
		return name;
	}

	public int getStudentId() {
		return student_id;
	}

	@Override
	public String toString() {
		return "Name: " + name + " Id: " + student_id + " Grades: " + grades;
	}

}
