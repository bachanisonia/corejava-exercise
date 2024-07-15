package com.learnjava.corejava;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.*;

import javax.sql.rowset.CachedRowSet;

public class ConcurrentHashMapExercise {

	public static void main(String[] args) {
		
		ConcurrentHashMap<Counter, Integer> counterMap = new ConcurrentHashMap<>(4);
		
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

		
		Runnable reportThread = () -> {
			/*
			System.out.println("Active Thread Count " + executorService.getActiveCount());
			System.out.println("Completed Thread Count " + executorService.getCompletedTaskCount());
			 */
			for (Map.Entry<Counter, Integer> entry : counterMap.entrySet()) {
				System.out.println(entry.getKey().getName() + " - " + entry.getValue());
			}
			
			int activeThreads = executorService.getActiveCount();
			if (activeThreads == 0) {
			
				System.out.println("Finished calculating prime numbers for all in the Map...!!!");
				scheduledExecutorService.shutdown();
				executorService.shutdown();
			}
		};
		
		scheduledExecutorService.scheduleWithFixedDelay(reportThread, 1, 5, TimeUnit.SECONDS);
		
		Counter c1 = new Counter("Sonia", 10000);
		Counter c2 = new Counter("Lalit", 20000);
		Counter c3 = new Counter("Sarah", 30000);
		Counter c4 = new Counter("Tanya", 20000);
		
		counterMap.put(c1, 0);
		counterMap.put(c2, 0);
		counterMap.put(c3, 0);
		counterMap.put(c4, 0);
		
		Iterator<Map.Entry<Counter, Integer>> it = counterMap.entrySet().iterator();
		
		while(it.hasNext()) {
			
			Map.Entry<Counter, Integer> entry = it.next();
			int no = entry.getKey().getN();
			String name = entry.getKey().getName();
			Counter tempCount = entry.getKey();
			
			System.out.println("Calculating " + no + "th prime number for " + name);
			
			Runnable r = new Runnable() {
				public void run() {
					
					int result = PrimeNumberUtil.getnthPrimeNumber(no);
					if (counterMap.containsKey(tempCount)) {
						counterMap.put(tempCount, result);
					}
				}
			};
			
			executorService.execute(r);
		}

	
	}
	

}


class Counter {
	
	String name;
	int n;
	
	public Counter(String name, int n) {
		this.name = name;
		this.n = n;
	}

	public String getName() {
		return name;
	}

	public int getN() {
		return n;
	}
	
	
	
}


class PrimeNumberUtil {
	
	public static int getnthPrimeNumber(int n) {
		
		int numOfPrimesFound = 0;
		int number = 1;
		int i;
		
		while(numOfPrimesFound < n) {
		
			number++;
			
			for (i=2; i<=number && number%i != 0; i++) {
			}
			
			if (i == number) {
				numOfPrimesFound++;
			}
			
		}
		
		return number;
	}
}