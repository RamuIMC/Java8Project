package com.project.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class LambdasMainTest {

	public static void main(String[] args) throws IOException {
	
			
			String result = processFile((BufferedReader br) ->	{
			try{
				return br.readLine() + "\n" + br.readLine();
				
			} catch (Exception e) {
				
				throw new RuntimeException("");
			}
		});
			
			System.out.println(result);
}
			

	private static String processFile(BufferedReaderProcessor p) throws FileNotFoundException {
		
		 URL url = LambdasMainTest.class.getClassLoader().getResource("data.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(url.getPath()));
		
		return p.process(br);
	}
	
	
		
	}

