package com.github.vshtishi;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
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

		// Creating Parallel Streams
		Stream<Person> stream = list.stream();
		Stream<Person> parallelStream = stream.parallel();
		Stream<Person> parallelStream2 = list.parallelStream();

		// The results in a parallel stream are not ordered or predictable
		System.out.println("Printing a parallel stream");
		list.parallelStream().forEach(s -> System.out.println(s + " "));

		// Performing Parallel Reductions
		System.out.println("Reduction operations in parallel streams: ");
		System.out.println(list.parallelStream().findAny().get());
		// Ordered operations in parallel streams maintain order
		System.out.println("Ordered operations in parallel streams: ");
		System.out.println(list.parallelStream().skip(1).limit(2).findFirst());
		// Creating Unordered Streams
		System.out.println("Unordered parallel stream:");
		list.stream().unordered().parallel().forEach(System.out::println);
		System.out.println("Reducing a parallel stream: ");
		System.out.println(list.parallelStream().reduce("", (s, p) -> s + p.getName().substring(0, 1), String::concat));
		// System.out.println(list.parallelStream().map(p-> p.getName().substring(0,1)).reduce("",String::concat));
		System.out.println("Collecting a parallel stream: ");
		ConcurrentMap<String, Integer> map1 = list.parallelStream()
				.collect(Collectors.toConcurrentMap(p -> p.getName(), p -> p.getId()));
		System.out.println(map1);
		ConcurrentMap<Integer,List<Person>> map2= list.parallelStream().collect(Collectors.groupingByConcurrent(p->p.getId()));
		System.out.println(map2);
		SortedSet<String> set = (list.parallelStream().collect(ConcurrentSkipListSet::new, (s, p) -> s.add(p.getName()),
				Set::addAll));
		System.out.println(set);
	}
}
