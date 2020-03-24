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
     
     public String getName(){
    	 return name;
     }
     public void setName(String Name){
    	 if(name==null || name.trim().length()==0){
    		 throw new IllegalArgumentException("Name is required");
    	 }
    	 this.name=name; 
     }
     
     public int getId(){
    	 return id;
     }
     
     public void setId(int id){
    	 if(id<0){
    		 throw new IllegalArgumentException("Id cannot be a negative nr");
    	 }
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
