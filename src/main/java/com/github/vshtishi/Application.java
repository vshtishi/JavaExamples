package com.github.vshtishi;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

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

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);
			// Obtaining synchronized collections
			Collections.synchronizedList(list);
			synchronized (list) {
				for (Person p : list)
					service.submit(()->System.out.println(p + " "));
			}
		} finally {
			if (service != null)
				service.shutdown();
		}

		// Using concurrent collection classes
		try {
			BlockingQueue<Person> blockingQueue = new LinkedBlockingQueue<>();
			blockingQueue.offer(person1);
			blockingQueue.offer(person2, 2, TimeUnit.SECONDS);
			System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// Handle Interruption
		}

		List<Integer> list1 = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
		// The iterator will iterate over the original elements prior to the modifications
		for (Integer item : list1) {
			System.out.print(item + " ");
			list1.add(10);
		}
		System.out.println();
		System.out.println("Size: " + list1.size());
		System.out.println(list1);

		

	}
}
