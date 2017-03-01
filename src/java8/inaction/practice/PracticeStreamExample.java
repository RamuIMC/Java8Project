package java8.inaction.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.sun.net.httpserver.Filter;

public class PracticeStreamExample {
	
	public static void main(String[] args){
		
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian,2011,900),
				new Transaction(raoul,2010,1000),
				new Transaction(raoul,2011,400),
				new Transaction(mario,2012,710),
				new Transaction(mario,2012,700),
				new Transaction(alan,2012,950));
		
		/*Find all transactions in the year 2011 and sort them by by value*/
		System.out.println("Find all transactions in the year 2011 and sort them by by value");
		
		System.out.println("");
		
		transactions.stream().filter(t->
		//System.out.println("filtering " +t.getValue());
		 t.getYear() <= 2011
	).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		/*Unique cities where traders work*/
		
		System.out.println("Unique cities where traders work");
		System.out.println("");
		
		transactions.stream().filter(t->t.getYear() >=2010).map(t->t.getTrader().getCity()).distinct().forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		/*Find all traders from Cambridge and sort them by name*/
		
		System.out.println("Find all traders from Cambridge and sort them by name");
		System.out.println("");
		
		transactions.stream().map(Transaction::getTrader).filter(trader->trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
		System.out.println("-------------------------");
		
		/*String of all traders names sorted alphabetically*/
		System.out.println("");
		System.out.println("String of all traders names sorted alphabetically");
		System.out.println("");
		
		String strNames = transactions.stream().map(trader->trader.getTrader().getName()).distinct()
				.sorted().reduce("",(n1,n2)->n1 + " " +n2);
		
		System.out.println("All Traders Names : "+strNames);
		
		System.out.println("-------------------------");
		
		/*Any Traders in Milan*/
		System.out.println("");
		System.out.println("Any Traders in Milan");
		System.out.println("");
		
		boolean milanBased = transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
		
		System.out.println("is Milan Based ? " +milanBased);
		
		System.out.println("-------------------------");
		
		/*Any Traders in Milan*/
		System.out.println("");
		System.out.println("Transaction value from Traders in Cambridge");
		System.out.println("");
		
		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);
		
		System.out.println("-------------------------");
		
		/*Highest value of all tranactions*/
		System.out.println("");
		System.out.println("Highest value of all tranactions");
		System.out.println("");
		
		Optional<Integer> intTrans = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		
		System.out.println("Highest value : "+intTrans);
		
		System.out.println("-------------------------");
		
		/*Smallest value of all tranactions*/
		System.out.println("");
		System.out.println("Smallest value of all tranactions");
		System.out.println("");
		
		Optional<Transaction> smallestValue = transactions.stream().reduce((t1,t2) ->t1.getValue()<t2.getValue() ? t1 : t2);
		
		System.out.println("smallet value : "+smallestValue);
		
		
		
		
		
			
	}
}
