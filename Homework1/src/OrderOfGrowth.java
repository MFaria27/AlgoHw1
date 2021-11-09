import java.util.Random;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.Stopwatch;

public class OrderOfGrowth {
	public OrderOfGrowth () {
		
	}
	
	public double linearFunction() {
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) {
			placeHolder += a[i];
		}
		return timer.elapsedTime()*1000;
	}
	
	public double quadraticFunction() {
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				placeHolder += a[i] + a[j];
			}
		}
		return timer.elapsedTime()*1000;
	}
	
	public double cubicFunction() {
		int[] a = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
		long placeHolder = 0;
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					placeHolder += a[i] + a[j] + a[k];
				}
			}
		}
		return timer.elapsedTime()*1000;
	}
}
