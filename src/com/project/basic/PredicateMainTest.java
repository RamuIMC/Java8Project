/**
 * 
 */
package com.project.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Ramakrishna
 *
 */
public class PredicateMainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> listOfIntegers = new ArrayList<>();
		
		listOfIntegers.add(70);
		listOfIntegers.add(50);
		listOfIntegers.add(40);
		listOfIntegers.add(60);
		listOfIntegers.add(30);
		listOfIntegers.add(160);
		listOfIntegers.add(80);
		
		
		List<Integer> nonEmptyIntegers = filter(listOfIntegers,(Integer i) -> i >10);
		
		System.out.println("Integers without sort " +nonEmptyIntegers);
		
		System.out.println("------------------------------------------");
		
		System.out.println("Sorted integers list using lambdas ");
				
		nonEmptyIntegers.sort((Integer i1,Integer i2) -> i1.compareTo(i2));
		System.out.println(nonEmptyIntegers);
		
		System.out.println("------------------------------------------");
		
		System.out.println("Sorted integers list using Method references");
		
		nonEmptyIntegers.sort(Integer::compareTo);
		System.out.println(nonEmptyIntegers);
		
		
		
	}

	private static List<Integer> filter(List<Integer> listOfIntegers, Predicate<Integer> p) {
		List<Integer> listOfNonEmptyIntegers = new ArrayList<>();
		
		for(Integer i:listOfIntegers){
			
			if(p.test(i)){
				
				listOfNonEmptyIntegers.add(i);
			}
		} 
		
		
		return listOfNonEmptyIntegers;
	}

}
