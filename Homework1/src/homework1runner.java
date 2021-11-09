import java.util.Random;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.*;

public class homework1runner {

	public static void main(String[] args) {

		//question1();
		//question2();
		//question3();
	}
	
	public static void question1() {
		
		Stackulator stackCalc = new Stackulator();
				
		//This method in stackulator uses StdIn() from the book, asking for a user input.
		//For the homeworks sack, we will manually give it strings in code, but feel free to uncomment this next line.
		//System.out.println(stackCalc.stackCalculateStdIn());
		
		System.out.println(stackCalc.stackCalculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
		System.out.println(stackCalc.stackCalculate("( ( 1 / 2 ) + ( 5 * 6 ) )"));
		System.out.println(stackCalc.stackCalculate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"));
		
		//Under proper PEMDAS, this should return 30.5.
		//for the stackulator to work, every expression needs to be in a parenthesis
		//As 1 / 2 is not surrounded by parenthesis, the stackulator will return an incorrect number
		System.out.println(stackCalc.stackCalculate("( 1 / 2 + ( 5 * 6 ) )"));
		
		//Added ceiling function and modulus function to stackulator
		System.out.println(stackCalc.stackCalculate("( 1 + ( ceil ( 0.4 ) )"));
		System.out.println(stackCalc.stackCalculate("( 5 * ( 9 % 5 ) )"));
	}
	
	public static void question2() {
		int[] arrSizes = {100, 1000, 10000, 100000, 250000};
		Sorting sortingAlgorithms = new Sorting();
		
		System.out.println("Linear Search:");
		for(int i : arrSizes) {
			int[] arr = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			int key = new Random().nextInt(1000);
			sortingAlgorithms.linearSearch(key, arr);
			System.out.println("Size: " + i + " Steps: " + sortingAlgorithms.lSteps);
			sortingAlgorithms.lSteps = 0;
		}
		
		System.out.println("");
		System.out.println("Binary Search:");
		for(int i : arrSizes) {
			int[] arr = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			int key = new Random().nextInt(1000);
			sortingAlgorithms.binarySearch(key, arr);
			System.out.println("Size: " + i + " Steps: " + sortingAlgorithms.bSteps);
			sortingAlgorithms.bSteps = 0;
		}
		
		System.out.println("");
		System.out.println("Recursive Binary Search:");
		for(int i : arrSizes) {
			int[] arr = IntStream.generate(() -> new Random().nextInt(1000)).limit(i).toArray();
			int key = new Random().nextInt(1000);
			sortingAlgorithms.recursiveBinarySearch(key, arr);
			System.out.println("Size: " + i + " Steps: " + sortingAlgorithms.rSteps);
			sortingAlgorithms.rSteps = 0;
		}
	}
	
	public static void question3() {
		OrderOfGrowth q3 = new OrderOfGrowth();
		StdOut.printf("Linear Function: %.1f ms\n", q3.linearFunction());
		StdOut.printf("Quadratic Function: %.1f ms\n", q3.quadraticFunction());
		StdOut.printf("Cubic Function: %.1f ms\n", q3.cubicFunction());
	}
	
	
}