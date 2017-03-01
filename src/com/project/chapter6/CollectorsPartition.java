package com.project.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsPartition {

	public static void main(String[] args) {
		
		List<Dish> dishes = Arrays.asList(
				new Dish(400, "MEAT", "chicken",false),
				new Dish(800, "MEAT", "mutton",false),
				new Dish(500, "MEAT", "pork",false),
				new Dish(600, "FISH", "prawns",false),
				new Dish(400, "FISH", "salmon",false),
				new Dish(200, "OTHER", "pizza",true),
				new Dish(300, "OTHER", "rice",true),
				new Dish(500, "OTHER", "french fries",true));
		
		/*Map<Boolean,List<Dish>> map1 = dishes.stream().collect(partitioningBy(Dish::isVegetarian));
		
		for(Entry<Boolean,List<Dish>> keyValue:map1.entrySet()){
			
			System.out.println(keyValue.getKey()+"="+Arrays.toString(keyValue.getValue().toArray()));
		}*/
		
		Map<Boolean,Dish> map2 = dishes.stream().collect(
				partitioningBy(Dish::isVegetarian,
						collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		
		for(Entry<Boolean,Dish> keyValue:map2.entrySet()){
			
			System.out.println(keyValue.getKey()+"="+keyValue.getValue().getItem());
		}
		Map<Boolean, Long> map3 = dishes.stream().collect(
				partitioningBy(Dish::isVegetarian,counting()));
		
		for(Entry<Boolean,Long> keyValue:map3.entrySet()){
			
			System.out.println(keyValue.getKey()+"="+keyValue.getValue());
		}

	}

}
