/**
 * 
 */
package com.project.java8.concurrency;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Ramakrishna
 *
 */
public class ThreadsAndRunnables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Runnable runnableTask = () -> {
		String thread = Thread.currentThread().getName();
		System.out.println("Thread Name is : "+thread+" and date is :"+LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println(thread+ " Thread was in sleep for 1 sec"+"and date is :"+LocalDateTime.now());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		};
		//runnableTask.run();
		
		Thread t = new Thread(runnableTask);
		t.start();
		System.out.println("Thread 1 is completed");
		
		Thread t2 = new Thread(runnableTask);
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		System.out.println("Thread 2 is completed");
		
		
	}

}
