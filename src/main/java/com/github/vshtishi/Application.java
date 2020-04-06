package com.github.vshtishi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

	public static void main(String[] args) {
		// Creating Paths
		Path path = Paths.get("C:\\Users\\Rando\\Desktop\\test.txt");
		Path path1 = FileSystems.getDefault().getPath("test.txt");
		Path path2 = Paths.get("C:\\Users\\Rando\\Desktop\\test.txt");
		Path path3 = Paths.get("C:\\Users\\Rando\\Desktop\\copy.txt");
		// Testing a Path
		System.out.println("File exists: " + Files.exists(path));
		// Testing uniqueness
		try {
			System.out.println("Are the same: " + Files.isSameFile(path, path2));
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		// Copying files
	//	try (InputStream is = new FileInputStream(path.toFile()); OutputStream out = new FileOutputStream(path3.toFile())) {
			//Copy stream data to file
			//Files.copy(is, Paths.get("C:\\Users\\Rando\\Desktop\\new1.txt"));
			//Copy file data to stream
			//Files.copy(Paths.get("C:\\Users\\Rando\\Desktop\\new.txt"),out);
	//	} catch (IOException e) {
		//	e.printStackTrace(System.out);
	//	}
		//Changing a File location, deleting a File
		try {
			//Files.move(path,Paths.get("C:\\Users\\Rando\\Desktop\\test-move.txt"));
			Files.delete(Paths.get("C:\\Users\\Rando\\Desktop\\demo.txt"));
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
}
