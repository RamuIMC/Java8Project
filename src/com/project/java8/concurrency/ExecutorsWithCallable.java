/**
 * 
 */
package com.project.java8.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Ramakrishna
 *
 */
public class ExecutorsWithCallable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Callable<String> callable = ()->{
			try
			{
				TimeUnit.SECONDS.sleep(5);
				return "success";	
			}
			catch(InterruptedException e){
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<String> ft = es.submit(callable);
		
		System.out.println("future done? " + ft.isDone());

		String result = null;
		try {
			System.out.println("Time before get() "+LocalDateTime.now());
			result = ft.get();
			System.out.println("Time after get() "+LocalDateTime.now());
			System.out.println("future done? " + ft.isDone());
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
		finally{
			if(ft.isDone()){
				es.shutdown();
				System.out.println("shut down completed");
			}
		}
		
		
		
		
	}

}
