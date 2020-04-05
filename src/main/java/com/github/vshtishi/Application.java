package com.github.vshtishi;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		// Creating Paths
		Path path = Paths.get("C:\\Users\\Rando\\Desktop\\test.txt");
		Path path1 = FileSystems.getDefault().getPath("test.txt");
		Path path2 = Paths.get("copy.txt");
		// Viewing the path
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("Element " + i + " is: " + path.getName(i));
		}
		System.out.println(path1.toString());
		// Accessing path components
		System.out.println("Filename is: " + path.getFileName());
		System.out.println("Root is: " + path.getRoot());
		System.out.println("Current parent is: " + path.getParent());
		// Checking Path type
		System.out.println("Is Path absolute: " + path1.isAbsolute());
		System.out.println("Absolute path: " + path1.toAbsolutePath());
		// Creating a new path
		System.out.println("Subpath from 2 to 3 is: " + path.subpath(2, 3));
		// Deriving a path
		System.out.println(path1.relativize(path2));
		// System.out.println(path2.relativize(path1));
		// Joining Path objects
		System.out.println("Joining paths: " + path.resolve(path2));
		// Cleaning up a path
		System.out.println("Normalized path: " + path.resolve(path2).normalize());
		//Checking for File Existence
		try{
			System.out.println("Real path: " +path.toRealPath());
		} catch(IOException e){
			//Handle I/O Exception
		}
		
		
	}
}
