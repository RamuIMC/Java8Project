/**
 * 
 */
package com.project;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ramakrishna
 *
 */
public class ConstructorRef {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Supplier<Apple> c1 = Apple::new;
		Apple a1 = c1.get();
		
		System.out.println("Apple weight " +a1);
		
		Function<Integer, Apple> f1 = Apple::new;
		
		Apple a2 = f1.apply(100);
		
		System.out.println(a2.getWeight());

	}

}
