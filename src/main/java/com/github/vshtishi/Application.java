package com.github.vshtishi;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Application {
	// Serializing and Deserializing objects
	public static List<Person> getObjects(File data) throws IOException, ClassNotFoundException {
		List<Person> list = new ArrayList<>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(data)))) {
			while (true) {
				Object object = in.readObject();
				if (object instanceof Person)
					list.add((Person) object);
			}
		} catch (EOFException e) {
			// File end reached
		}
		return list;
	}

	public static void createObjectsFile(List<Person> list, File data) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(data)))) {
			for (Person p : list)
				out.writeObject(p);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person1 = new Person("Ann", 101);
		Person person2 = new Person("Jane", 232);
		Person person3 = new Person("John", 103);
		Person person4 = new Person("Harry", 101);
		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		File file = new File("C:\\Users\\Rando\\Desktop\\test.txt");
		createObjectsFile(list, file);
		System.out.println(getObjects(file));
	}
}
