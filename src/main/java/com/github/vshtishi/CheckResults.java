package com.github.vshtishi;

import java.util.concurrent.*;

public class CheckResults {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				for (int i = 0; i < 500; i++)
					CheckResults.counter++;
			});
			Future<Integer> result2=service.submit(() -> 10+5);
			System.out.println(result.get(10, TimeUnit.SECONDS));//The get() method returns null because Runnable returns void
			//Using Callable which supports a return type
			System.out.println(result2.get());
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
		}
		//Awaiting all tasks to finish
		if(service!=null){
			service.awaitTermination(1, TimeUnit.SECONDS);
			//Checking whether all tasks are finished
			if(service.isTerminated())
				System.out.println("All tasks finished");
			else
				System.out.println("At least one task is still running");
		}
	}
}
