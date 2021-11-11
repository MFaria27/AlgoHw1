import edu.princeton.cs.algs4.StdOut;

public class BubbleSort {
	public int bSteps;
	
	public BubbleSort() {
		
	}
	
	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				bSteps++; //A step will be recorded every time a pair of values is compared.
				//Bubble sort compares a pair of values every iteration. If the value in front of the other is larger, the two values are swapped.
				//This continues to happen until the largest value is "bubbled" up to the end of the array.
				//After traversing the entire array, all values will be properly bubbled-up and the array will be sorted
				if(less(a[j+1], a[j])) { 
					exch(a, j, j+1);
				}
			}
		}
	}
	
	//The Less(v, w) function returns true if v is less than w using eclipse's compareTo() function.
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	//The exch, or exchange function, takes an array and the indices that the array will swap.
	//It does this by setting the first value to a placeholder variable, setting the first value as the second value, then setting the second value to the placeholder variable.
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	//The show function takes an array and prints all the values ({"C", "A", "T"} will display "CAT").
	public void show(Comparable[] a) {
		for (Comparable element : a)
			StdOut.print(element + " ");
		StdOut.println();
	}

	//The isSorted function returns a boolean value that represents whether or not an array has been sorted.
	//It checks this by using the less() function, and making sure that every value is less than the next. 
	//If it is not, it will return false.
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
}
