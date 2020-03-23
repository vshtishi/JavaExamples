package com.github.vshtishi;

public class Person {
     private String name;
     private int id;
     public Person(){
    	 
     }
     public Person(String name, int id){
    	 this.name=name;
    	 this.id=id;
     }
     //Overriding methods defined in Object
     @Override
     public String toString(){
    	 return "Name: "+name;
     }
     
     @Override
     public boolean equals(Object obj){
    	 if(obj==this)
    		 return true;
    	 if(!(obj instanceof Person))
    		 return false;
    	 Person otherPerson=(Person)obj;
    	 return this.id==otherPerson.id;
     }
     
}
