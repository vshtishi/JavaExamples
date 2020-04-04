package com.github.vshtishi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Rando\\Desktop\\test.txt");
		// Using java.io.File methods
		System.out.println("The file exists: " + file.exists());
		System.out.println("The file's name is: " + file.getName());
		System.out.println("The file denoted by the path is a file: " + file.isFile());
		System.out.println("Parent path: " + file.getParent());
		System.out.println("File size: " + file.length());
		// Retrieving the local separator character
		System.out.println("File separator: " + System.getProperty("file.separator"));
		// System.out.println(java.io.File.separator);

		// Reading the contents of a file
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			System.out.println(bufferedReader.readLine());
			// Marking the stream
			if (bufferedReader.markSupported()) {
				bufferedReader.mark(100);
				System.out.println(bufferedReader.readLine());
				System.out.println(bufferedReader.readLine());
				bufferedReader.reset();
			}
			// Skipping over data
			bufferedReader.skip(2);
			System.out.println(bufferedReader.readLine());
		}
	}
}
