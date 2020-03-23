package com.github.vshtishi;

public class Application {
	
	
    public static void main(String[] args){
    	Person employee=new Employee();
    	Employee employee2=null;
    	Person person=new Employee();
    	//The instanceof operator
    	boolean b1=employee instanceof Employee;
    	boolean b2=employee instanceof Person;
    	boolean b3=employee instanceof Object;
    	boolean b4=employee2 instanceof Employee;
    	
    	System.out.println("instanceof returns "+b1+" because employee is an instance of Employee.");
    	System.out.println("instanceof returns "+b2+" because employee is an instance of its superclass, Person.");
    	System.out.println("instanceof returns "+b3+" because all Java classes inherit from Object");
    	System.out.println("instanceof returns "+b4+" because employee2 points to null.");
    	
    	//Determining if an instance is a subclass of a particular object before applying an explicit cast
    	if(person instanceof Employee){
    	   employee2=(Employee)person;
    	}
    	System.out.println(employee2); 
    	
        Person p1=new Person("Ann",001);
        Person p2=new Person("John",002);
        System.out.println(p1);
        System.out.println(p1.equals(p2));
    }
}
