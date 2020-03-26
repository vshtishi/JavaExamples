package com.github.vshtishi;

public class Employee extends Person implements Workable<Employee> {

	Employee(String name, int id){
		super(name,id);
	}
	
	public void work(Employee e){
		System.out.println(e.getName() + " is working");
	}
}
