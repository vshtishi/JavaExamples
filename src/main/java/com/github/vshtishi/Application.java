package com.github.vshtishi;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
	//Returning an Optional
     public static Optional<Double> average(int... scores){
    	 if(scores.length==0)
    		 return Optional.empty();
    	 int sum=0;
    	 for(int score: scores)
    		 sum += score;
    	 return Optional.of((double)sum/scores.length);
    	     
     }
	public static void main(String[] args){
		//An Optional can be empty or contain a value
		System.out.println(average(95,100));
		System.out.println(average());
		
		//Checking if the Optional contains a value
          Optional<Double> optional=average(50,100);
          if(optional.isPresent()){
        	  System.out.println(optional.get());
          }
	   
        //If a value is null, we assign an empty Optional. Otherwise, we wrap the value
          Double d=null;
          Optional<Double> opt=Optional.ofNullable(d);
          System.out.println("Empty optional assigned to a null value: " +opt);
		
        //Using Optional instance methods
          optional.ifPresent(System.out::println); //Prints the value if it is present
          System.out.println(opt.orElse(Double.NaN)); //Prints NaN if a value is not present
          System.out.println(opt.orElseGet(()-> 0.0)); //Prints the result returned from Supplier
          System.out.println(optional.orElseThrow(()-> new IllegalStateException()));  //Gets Supplier to create an Exception that should be thrown
          
       //Creating Stream sources
          Stream<String> empty=Stream.empty(); //Creates an empty stream
          Stream<Integer> singleElement=Stream.of(1); //Creates a stream with a single element
          Stream<Integer> fromArray=Stream.of(1,2,3); //Creates a stream with multiple elements
          //Converting from a list to a stream
          List<Integer> list= Arrays.asList(1,2,3);
          Stream<Integer> fromList= list.stream();
          
	   //Terminal stream operations	 
		 System.out.println("The number of elements is: " +fromList.count());
		 
		 Stream<String> s1=Stream.of("Ann", "Jane", "Harry");
		 Optional<String> minimum= s1.min((s,t) -> s.length()-t.length());
		 System.out.print("The minimum value of the stream is: ");
		 minimum.ifPresent(System.out::println);
		 
		 Stream<String> s2=Stream.of("Ann", "Jane", "Harry");
		 Optional<String> maximum= s2.max((s,t) -> s.length()-t.length());
		 System.out.print("The maximum value of the stream is: ");
		 maximum.ifPresent(System.out::println);
		 
	   	 Stream<Double> infinite=Stream.generate(Math::random);
	   	 infinite.findAny().ifPresent(System.out::println);
		 fromArray.findFirst().ifPresent(System.out::println);
		 
		 List<Integer> list1=Arrays.asList(7,8,9,10);
		 Predicate<Integer> pred= x -> x>10;
		 System.out.print("Searching the stream :");
		 System.out.print(list.stream().anyMatch(pred)+ " "); //There is no match for any element greater than 10 in the stream
		 System.out.print(list.stream().noneMatch(pred)+ " "); //None of the elements match the condition
		 pred= x -> x<=10;
		 System.out.println(list.stream().allMatch(pred)); //All of the elements match the condition
		 System.out.println("Printing the stream:");
		 list1.stream().forEach(System.out::println);
		 
		 Stream<String> s3=Stream.of("John"," ","Doe");
		 String fullName=s3.reduce("",String::concat);
		 System.out.println("(1)Reducing the stream: " + fullName);
		 
		 Stream<Integer> s4=Stream.of(3,4,5);
		 System.out.println("(2)Reducing the stream: " + s4.reduce(1, (a,b) -> a*b));
		 
		 Stream<String> s5=Stream.of("s","t","r","e","a","m");
		 TreeSet<String> set=s5.collect(Collectors.toCollection(TreeSet::new));
		 System.out.println("Using Collectors: " + set);
    }
}
