package com.github.vshtishi;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
	public void printName(List<Person> list, int i) {
		System.out.print(list.get(i).getName() + " ");

	}

	public void printId(List<Person> list, int i) {
		System.out.print(list.get(i).getId() + " ");
	}

	public void printRecord(List<Person> list, CyclicBarrier c1, CyclicBarrier c2, int i) {
		try {
			printName(list, i);
			c1.await();
			System.out.println("*");
			c2.await();
			printId(list, i);
		} catch (InterruptedException | BrokenBarrierException e) {
			// Handle checked exception
		}
	}

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
		// Creating a Cyclic Barrier
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			Application app = new Application();
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4);
			service.submit(() -> app.printRecord(list, c1, c2, 0));
			service.submit(() -> app.printRecord(list, c1, c2, 1));
			service.submit(() -> app.printRecord(list, c1, c2, 2));
			service.submit(() -> app.printRecord(list, c1, c2, 3));
		} finally {
			if (service != null)
				service.shutdown();
		}

	}
}
