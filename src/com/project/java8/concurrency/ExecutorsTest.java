/**
 * 
 */
package com.project.java8.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ramakrishna
 *
 */
public class ExecutorsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*1. ExecutorService in Java Concurrency API works as replacement for Threads
		 *2. Executors: We can define/manage pool of threads and run multiple tasks asynchronously.
		 *With Executors, we do not have to create threads manually */
		ExecutorService es= Executors.newSingleThreadExecutor();
		es.submit(()->{
			String thread = Thread.currentThread().getName();
			try {
				TimeUnit.SECONDS.sleep(8);
				System.out.println("Hello " + thread);
			    int a= 5*5;
			    System.out.println("multiply is : "+a);
			} catch (Exception e) {
				System.out.println("error in sleep method");
				e.printStackTrace();
			}
		    
		});
		
		try{
			System.out.println("will shut down using shutDown()");
			System.out.println("current time is : "+LocalDateTime.now());
			es.shutdown();
			System.out.println("current time after shutdown() is : "+LocalDateTime.now());
			es.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("current time await is : "+LocalDateTime.now());
			
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			if(! es.isTerminated()){
				  System.err.println("cancel non-finished tasks");
			}
			 es.shutdownNow();
			    System.out.println("shutdown finished");
		}

	}

}
