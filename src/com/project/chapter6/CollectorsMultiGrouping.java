package com.project.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsMultiGrouping {

	public static void main(String[] args) {
		List<Dish> dishes = Arrays.asList(
				new Dish(400, "MEAT", "chicken"),
				new Dish(600, "MEAT", "mutton"),
				new Dish(500, "MEAT", "pork"),
				new Dish(600, "FISH", "prawns"),
				new Dish(400, "FISH", "salmon"),
				new Dish(200, "OTHER", "pizza"),
				new Dish(300, "OTHER", "rice"),
				new Dish(500, "OTHER", "french fries"));
		
		//Group By Type
		Map<String,List<Dish>> groupByType = dishes.stream().collect(groupingBy(Dish::getType));
		
		for(Entry<String, List<Dish>> keyValues:groupByType.entrySet()){
			System.out.println("Dish TYPE is : " +keyValues.getKey());
			System.out.println("------------------------------------");

			for(Dish dish:keyValues.getValue()){
				System.out.println(dish.getItem()+" ");
			}
			
			System.out.println("------------------------------------");
			
			
			
		}
		//GroupBy Type and Calories
		Map<String, Map<CaloricLevel, List<Dish>>> groupByTypeAndCal = dishes.stream().collect(
				groupingBy(Dish::getType,
						groupingBy(dish->{
							if(dish.getCalories() <= 400) 
								return CaloricLevel.DIET;
							else if(dish.getCalories() <= 700){
								return CaloricLevel.NORMAL;
							}
							else{
								return CaloricLevel.FAT;
							}
						})));
		for(Entry<String, Map<CaloricLevel, List<Dish>>> keyValues:groupByTypeAndCal.entrySet()){
			System.out.println("******************************************");
			System.out.println("Dish Type-------"+keyValues.getKey());
			System.out.println("******************************************");
			for(Entry<CaloricLevel, List<Dish>> innerKeyValue: keyValues.getValue().entrySet()){
				System.out.println("CaloricLevel is: "+innerKeyValue.getKey());
				for(Dish dish:innerKeyValue.getValue()){
					
					System.out.println("Dish Calorie : "+dish.getCalories());
					System.out.println("Dish Type is : "+dish.getType());
					System.out.println("Dish Item is :"+dish.getItem());
				}
				
			}
			System.out.println("-----------------------------------------------");
			System.out.println("-----------------------------------------------");
			
		}
		
		//GroupBy Type and MAX Calories using maxBy Collector
		Map<String, Optional<Dish>> groupByTypeAndMaxCal = dishes.stream().collect(
				groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
		
		for(Entry<String, Optional<Dish>> keyValues:groupByTypeAndMaxCal.entrySet()){
			
			System.out.println("Max Dish Type : "+keyValues.getKey());
			
			if(keyValues.getValue().isPresent()){
				System.out.println("Max Dish Item is :"+keyValues.getValue().get().getItem());
			}
			else{
				System.out.println("No data found");
			}
			
		}
		System.out.println("----------------------------------------------------");
		//GroupBy Type and MAX Calories using maxBy Collector
		Map<String,Dish> map1=dishes.stream().collect(
				groupingBy(Dish::getType,
						collectingAndThen(
								maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
		
		for(Entry<String, Dish> keyValue:map1.entrySet()){
			System.out.println("MAX Dish Type is : "+keyValue.getKey());
			System.out.println("MAX Calories is :" +keyValue.getValue().getCalories());
		}
	}

}
