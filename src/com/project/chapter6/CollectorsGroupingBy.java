package com.project.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorsGroupingBy {

	public static void main(String[] args) {
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction("$", "tr1", 50),
				new Transaction("$", "tr2", 60),
				new Transaction("$", "tr3", 50),
				new Transaction("#", "tr4", 100),
				new Transaction("#", "tr5", 20),
				new Transaction("*", "tr6", 10),
				new Transaction("$", "tr7", 40),
				new Transaction("*", "tr8", 60),
				new Transaction("#", "tr9", 50));
		Map<String,List<Transaction>> map = transactions.stream().collect(groupingBy(Transaction::getCurrency));
		
		for(Entry<String,List<Transaction>> entrySet:map.entrySet()){
			System.out.println("-------------------------------");
			System.out.println("Currency is "+entrySet.getKey());
			System.out.println("");	
			/*for(Transaction trans:entrySet.getValue()){
				System.out.println(trans.getCurrency());
				System.out.println(trans.getName());
				System.out.println(trans.getValue());
			}*/
		}
		
		System.out.println("Using counting()-------------------------------");
				
		long nofTrans = transactions.stream().map(Transaction::getValue).filter(i->i==50).collect(counting());
		System.out.println("How many transactions ? "+nofTrans);
		
		System.out.println("Using count()-------------------------------");
		long nofTrans2 = transactions.stream().map(Transaction::getValue).filter(i->i==50).count();
		System.out.println("How many transactions ? "+nofTrans2);
		
		System.out.println("Maximum value in a stream");
		
		List<Dish> dishes = Arrays.asList(
				new Dish(150),
				new Dish(160),
				new Dish(50),
				new Dish(100));
		
		Comparator<Dish> sortedCalories = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> maxDish = dishes.stream().collect(maxBy(sortedCalories));
		
		if(maxDish.isPresent()){
			
			Dish dish = maxDish.get();
			
			System.out.println("Max Dish value : "+dish.getCalories());
			
		}
		else{
			System.out.println("No Value");
		}
		
		int sum3= dishes.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println("Sum of calories in Dish menu using reduce method :"+sum3);
		
		int sum= dishes.stream().collect(reducing(0,Dish::getCalories,(a,b)->a+b));
		
		System.out.println("Sum of calories in Dish menu using reducing method :"+sum);
		
		int sum2 = (int) dishes.stream().collect(summingInt(Dish::getCalories));
		
		System.out.println("Sum of calories in Dish menu using Summing method :"+sum2);
		
		
		
		//IntSummaryStatistics
		
		IntSummaryStatistics intSummaryStatistics =  dishes.stream().collect(summarizingInt(Dish::getCalories));
		
		System.out.println("Count is: "+intSummaryStatistics.getCount());
		System.out.println("Sum is :" +intSummaryStatistics.getSum());
		System.out.println("Average is : "+intSummaryStatistics.getAverage());
		System.out.println("MAX value is :"+intSummaryStatistics.getMax());
		System.out.println("MIN value is :"+intSummaryStatistics.getMin());
		
		
	}

}
