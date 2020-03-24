package com.github.vshtishi;

import java.util.List;

//Using the Builder Pattern
public class StudentBuilder {

	private String name;
    private int student_id;
    private List<Integer> grades;
    
    public StudentBuilder setName(String name){
    	this.name=name;
    	return this;
    }
    
    public StudentBuilder setStudentId(int student_id){
    	this.student_id=student_id;
    	return this;
    }
    
    public StudentBuilder setGrades(List<Integer> grades){
    	this.grades=grades;
    	return this;
    }
    public Student build(){
    	return new Student(name,student_id,grades);
    }
}
