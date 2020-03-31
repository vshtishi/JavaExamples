package com.github.vshtishi;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckResults {
	// Using Atomic Classes to protect data
	private AtomicInteger counter = new AtomicInteger(0);

	private void incrementAndReport() {
		// counter++ is not a thread safe operation
		System.out.print(counter.incrementAndGet() + " ");
	}

	public synchronized void printResults() {
		// counter++ is not a thread safe operation
		System.out.print("Result: " + counter.incrementAndGet() + " ");
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);

			CheckResults result = new CheckResults();
			for (int i = 0; i < 10; i++) {
				// service.submit(() -> result.incrementAndReport());
				service.submit(() -> result.printResults());
			}
		} finally {
			if (service != null)
				service.shutdown();
		}

	}
}
