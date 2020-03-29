package com.github.vshtishi;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {

	public static void main(String[] args) {

		Person person1 = new Person("Ann", 101);
		Person person2 = new Person("Jane", 232);
		Person person3 = new Person("John", 103);
		Person person4 = new Person("Harry", 101);
		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		// Using common intermediate operations in streams
		System.out.println("Filtering a stream: ");
		list.stream().filter(x -> x.getName().startsWith("J")).forEach(System.out::println);
		System.out.println("Removing duplicate values from the stream: ");
		list.stream().distinct().forEach(System.out::println);
		System.out.println("Making a stream smaller");
		list.stream().skip(1).limit(2).forEach(System.out::println);
		System.out.println("Mapping the elements of the stream: ");
		list.stream().map(s -> s.getName().charAt(0)).forEach(System.out::println);
		System.out.println("Sorted stream: ");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("Sorted using Comparator: ");
		list.stream().sorted((s, t) -> (s.getName()).compareTo(t.getName())).forEach(System.out::println);

		// Creating primitive streams
		DoubleStream stream = DoubleStream.of(1.1, 1.2, 1.3);
		System.out.print("Generating a range: ");
		IntStream range = IntStream.range(1, 6);
		range.forEach(System.out::print);
		System.out.println(" ");
		System.out.print("Generating a closed range: ");
		IntStream rangeClosed = IntStream.rangeClosed(1, 5);
		rangeClosed.forEach(System.out::print);
		System.out.println(" ");

		IntStream intStream = list.stream().mapToInt(s -> s.getId());
		System.out.println("Stream sum: " + intStream.sum());

		// Collecting into Maps
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(s -> s.getName(), k -> k.getId()));
		System.out.println(map);
		// Collecting using Grouping
		Map<String,List<Person>> map1 = list.stream().collect(Collectors.groupingBy(s -> s.getName().substring(0,1)));
		System.out.println(map1);
		// Collecting using Partitioning
		Map<Boolean, List<Person>> map2 = list.stream().collect(Collectors.partitioningBy(s -> s.getId() <= 103));
		System.out.println(map2);
		

	}
}
