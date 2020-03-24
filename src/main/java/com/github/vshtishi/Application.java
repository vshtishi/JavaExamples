package com.github.vshtishi;

import java.util.Arrays;

public class Application {
	
	public static void main(String[] args){
		StudentBuilder studentBuilder=new StudentBuilder();
    	studentBuilder
    	      .setName("Ann")
    	      .setStudentId(001)
    	      .setGrades(Arrays.asList(8,9,10));
    	
    	Student student1=studentBuilder.build();
    	System.out.println(student1);
    	
    	Student student2=new StudentBuilder()
    	      .setName("John")
      	      .setStudentId(002)
      	      .setGrades(Arrays.asList(9,10,10))
      	      .build();
    	
    	System.out.println(student2);
    	
    	final Card card=CardFactory.getCard("student");
    	System.out.println(card);
    }
}
