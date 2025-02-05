package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
			Создайте сто потоков которые будут вычислять факториал
			числа равного номеру этого потока и выводить результат на
			экран.	
		 */
		 FactorialThreads.runFactorial();
		 /*
		  	Написать код для многопоточного подсчета суммы элементов
	    	массива целых чисел. Сравнить скорость подсчета с простым
		   	алгоритмом.
		  */
		 ArraySum.runArraySum();
	}

}
