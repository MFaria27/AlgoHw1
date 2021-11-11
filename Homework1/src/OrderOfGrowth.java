import java.util.Random;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.Stopwatch;

public class OrderOfGrowth {
	public OrderOfGrowth () {
		
	}
	
	public double linearFunction() {
		//generate an array of size 100000 of ints ranging from 0-1000
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) { //Function of O(n) 
			placeHolder += a[i];
		}
		return timer.elapsedTime()*1000; //elapsedTime() returns seconds, so multiply by 1000 milliseconds
	}
	
	public double quadraticFunction() {
		//generate an array of size 100000 of ints ranging from 0-1000
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) { //Function of O(n^2)
				placeHolder += a[i] + a[j];
			}
		}
		return timer.elapsedTime()*1000; //elapsedTime() returns seconds, so multiply by 1000 milliseconds
	}
	
	public double cubicFunction() {
		//generate an array of size 100000 of ints ranging from 0-1000
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) { //Function of O(n^3)
					placeHolder += a[i] + a[j] + a[k];
				}
			}
		}
		return timer.elapsedTime()*1000; //elapsedTime() returns seconds, so multiply by 1000 milliseconds
	}
}
