package sample;

import java.math.BigInteger;

public class FactorialThreads {

	public static void runFactorial() {
		
		for(int i = 0; i < 100; i++) {
			final int num = i;
			
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Factorial " + num + " -> " + factorial(num));

			}
		});	
		thread.start();
		}
	}
	public static BigInteger factorial (int n) {
		
		BigInteger result = BigInteger.ONE;
		
		for(int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
