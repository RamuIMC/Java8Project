package com.project.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NoOfOccMainTest {

	public static void main(String[] args) {
		
		List<String> listOfStr = Arrays.asList("a","b","b","a","c","d","d","d","c","a","a","b");
		
		Map<String,Integer> hashMap = new HashMap<String,Integer>();
		for(String str:listOfStr){
			if(hashMap.get(str)!=null){
				hashMap.put(str, hashMap.get(str).intValue()+1);				
			}
			else{
				hashMap.put(str, 1);
			}			
		}
		Set<Entry<String, Integer>> entrySet = hashMap.entrySet();
		
		for(Entry<String, Integer> keyValue : entrySet){
			
			System.out.println(keyValue.getKey()+" -------------- " +keyValue.getValue()+" time(s)");
		}

	}

}
