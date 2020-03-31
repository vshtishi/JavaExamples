package com.github.vshtishi;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        //Creating Threads with the ExecutorService
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(() -> System.out.println("Printing List"));
			service.execute(() -> {
				for (Person e : list)
					System.out.println(e); //The main() method is an independent thread from the Executor service
			});
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
