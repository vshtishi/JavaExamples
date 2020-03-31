package com.github.vshtishi;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTasks {
	public static void main(String[] args){
		// Scheduling tasks
		System.out.println("Scheduled Tasks");
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Task 1");
		Callable<String> task2 = () -> "Task2";

		// The first task is scheduled 10 seconds in the future
		Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
		// The second task is scheduled 2 min
		Future<?> result2 = service.schedule(task2, 1, TimeUnit.MINUTES);
		
	}
}
