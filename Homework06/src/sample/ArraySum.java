package sample;

import java.util.Random;

public class ArraySum {
	private static int[] arr = new int[100000000];
	private static int THREAD = 6;
	
	public static void runArraySum() {
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(100) + 1;
		}
		
		long startTime = System.currentTimeMillis();
		long simpleSum = simpleSum();
		long endTime = System.currentTimeMillis();
		System.out.println("Обычный подсчет : " +simpleSum + " -> " + (endTime - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		long paralleSum = multiThreadSum();
		endTime = System.currentTimeMillis();
		System.out.println("Многопоточный подсчет : " + multiThreadSum() + " -> " + (endTime - startTime) + "ms");
	}
	public static long simpleSum() {
		long sum = 0;
		for(int num : arr) {
			sum+= num;
		}
		return sum;
	}
	public static long multiThreadSum() {
		Thread[] threads = new Thread[THREAD];
		long[] partialsSums = new long[THREAD];
		
		int size = arr.length / THREAD;
		for(int i = 0; i < THREAD; i++) {
			final int index = 1;
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int start = index * size;
					int end = (index == THREAD - 1) ? arr.length : (index + 1) * size;
					long sum = 0;
					for(int j = start; j < end; j++ ) {
						sum += arr[j];
					}
					partialsSums[index] = sum;
				}
			});
			threads[i].start();
		}
		for(int i = 0; i < THREAD; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		long totalSum = 0;
		for(long sum : partialsSums) {
			totalSum += sum;
		}
		return totalSum;
	}
}
