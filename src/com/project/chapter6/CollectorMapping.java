/**
 * 
 */
package com.project.chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * @author Ramakrishna
 *
 */
public class CollectorMapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Dish> dishes = Arrays.asList(
				new Dish(400, "MEAT", "chicken"),
				new Dish(800, "MEAT", "mutton"),
				new Dish(500, "MEAT", "pork"),
				new Dish(600, "FISH", "prawns"),
				new Dish(400, "FISH", "salmon"),
				new Dish(200, "OTHER", "pizza"),
				new Dish(300, "OTHER", "rice"),
				new Dish(500, "OTHER", "french fries"));
		
		Map<String, Set<CaloricLevel>> map1= dishes.stream().collect(groupingBy(Dish::getType,
				mapping(dish->{
					if(dish.getCalories()<=400) return CaloricLevel.DIET;
					else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
					else return CaloricLevel.FAT;
				}, toCollection(HashSet::new))));
					
			for(Entry<String, Set<CaloricLevel>> keyValue:map1.entrySet())	{
				
				//System.out.println("Dish Type is : "+keyValue.getKey());
				System.out.println(keyValue.getKey()+"="+Arrays.toString(keyValue.getValue().toArray()));
				/*for(CaloricLevel cal:keyValue.getValue()){
					System.out.println(cal);
					
				}
				*/
			}
				
		
	}

}
