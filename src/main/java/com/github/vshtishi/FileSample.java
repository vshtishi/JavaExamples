package com.github.vshtishi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSample {

	public static void copy1(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
				// out.flush();
			}
		}
	}

	public static void copy2(File source, File destination) throws IOException {
		List<String> data= new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source));
				BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
                 String s;
                 while((s=reader.readLine())!=null)
                	 data.add(s);
                 for(String str: data){
                	 writer.write(str);
                	 writer.newLine();
                 }
		}
	}
	
	public static void main(String[] args) throws IOException{
		File source= new File("C:\\Users\\Rando\\Desktop\\test.txt");
		File destination= new File("C:\\Users\\Rando\\Desktop\\copy.txt");
		copy1(source,destination);
		
	}
	
	
	
}
