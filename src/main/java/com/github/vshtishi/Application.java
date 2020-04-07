package com.github.vshtishi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Application {

	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("C:\\Users\\Rando\\Desktop\\copy.txt");
		Path path2 = Paths.get("C:\\Users\\Rando\\Desktop\\copy2.txt");
		//File Attributes
		BasicFileAttributes data= Files.readAttributes(path1,BasicFileAttributes.class);
		System.out.println("Is File: " + data.isRegularFile());
		System.out.println("Is Directory: " + data.isDirectory());
		System.out.println("Is Readable: " + Files.isReadable(path1));
		System.out.println("Is Executable: " + Files.isExecutable(path1));
		try{
			System.out.println("File size in bytes: "+data.size());
			System.out.println("Is Hidden: " + Files.isHidden(path1));
			System.out.println("Last modified: " + Files.getLastModifiedTime(path1).toMillis());
		}
		catch(IOException e){
			e.printStackTrace(System.out);
		}
		System.out.println("Reading from the stream: ");
		try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset());
				BufferedWriter writer = Files.newBufferedWriter(path2, Charset.defaultCharset())) {
			
			// Reading from the stream
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				System.out.println(currentLine);
				writer.write(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}

		// Reading all of the lines of a text file
		try {
			final List<String> allLines = Files.readAllLines(path1);
			System.out.println("Printing file contents:");
			for (String line : allLines)
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
}
