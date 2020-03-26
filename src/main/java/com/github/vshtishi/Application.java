package com.github.vshtishi;
import java.util.*;

public class Application {
	//Using unbounded wildcards
	public static void printList(List<?> list){
		for(Object x: list)
			System.out.println(x);
	}
	
	public static void main(String[] args){
		Person person1=new Person("Ann",001);
		Person person2=new Person("James",056);
		Person person3=new Person("Sophie",007);
		Employee employee1=new Employee("John",002);
		List<Person> people=new ArrayList<>();
		List<Employee> employees=new ArrayList<>();
		people.add(person1);
		people.add(person2);
		people.add(person3);
		employees.add(employee1);
		printList(people);
		printList(employees);
		Collections.sort(people);
		System.out.println("Sorted list using Comparable:");
		printList(people);
		
		//Sorting List by using Comparator
		/*
		 * Without using Lambdas:
		    Comparator<Person> byName=new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return (p1.getName()).compareTo(p2.getName()); //Calling String's compareTo()
			}
		};
		*/
		Comparator<Person> byName=(p1,p2)-> (p1.getName()).compareTo(p2.getName());
		Collections.sort(people, byName);
		System.out.println("Sorted list using Comparator:");
		printList(people);
		
		//Removing Conditionally
		  people.removeIf(s-> s.getName().startsWith("A"));
		  System.out.println("List after removing conditionally:");
		  printList(people);
		  
		//Using upper-bounded wildcards
		 List<? extends Person> list1=new ArrayList<Employee>();
		 //Using lower-bounded wildcards
		 List<? super Employee> list2=new ArrayList<Object>();
		 
		 //Using the Set interface
		 Student student1=new Student("Jane",101,Arrays.asList(5,6,7));
		 Student student2=new Student("Harry",101,Arrays.asList(7,8,7));
		 Student student3=new Student("Sarah",103,Arrays.asList(8,9,10));
		 Set<Integer> set=new HashSet<>();
		 set.add(student1.getStudentId());
		 boolean b=set.add(student2.getStudentId());
		 set.add(student3.getStudentId());
		 System.out.println(b); //A set must preserve uniqueness
		 
		 System.out.println();
		 
		 //Using the Map interface
		 Map<String,Integer> map=new HashMap<>();
		 map.put(student1.getName(), student1.getStudentId());
		 map.put(student2.getName(), student2.getStudentId());
		 map.put(student3.getName(), student3.getStudentId());
		 System.out.println("Student Map Keys: ");
		 for(String k: map.keySet())
			 System.out.print(k + " ");
		 System.out.println(" ");
		 
		 //Updating the value of a specific key in the map
		 map.computeIfAbsent("Sarah",k->111);
		 System.out.println("The value was not updated because the key was already present: " +map.get("Sarah"));
		 
		 map.computeIfPresent("Sarah", (k,v) -> v+1);
		 System.out.println("The value of the specified key was updated to: " +map.get("Sarah"));
		 
		 /*
		 Map<String,Integer> map2=new TreeMap<>();
		 map2.put(student1.getName(), student1.getStudentId());
		 map2.put(student2.getName(), student2.getStudentId());
		 map2.put(student3.getName(), student3.getStudentId());
		 System.out.println("Student Map Keys: ");
		 for(String k: map2.keySet())
			 System.out.print(k + ",");
		*/
		 
		 //Using the Queue interface
		 Queue<Integer> queue =new ArrayDeque<>();  //FIFO
		 queue.offer(1);
		 queue.offer(2);
		 queue.offer(3);
		 System.out.println("The first element: " + queue.peek());
		 System.out.println("Removing first element: " + queue.poll());
		 System.out.println("The first element now is: " + queue.peek());
		 
		 System.out.println();
		 
		 ArrayDeque<Integer> stack =new ArrayDeque<>(); //LIFO
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 System.out.println("The element on top of the stack: " + stack.peek());
		 System.out.println("Removing the element on top: " + stack.poll());
		 System.out.println("The first element now is: " + stack.peek());
		 
		 
		 
    }
}
