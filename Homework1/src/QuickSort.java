import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public int qSteps;
	
	public QuickSort() {
		
	}

	public void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		quickSort(a, 0, a.length-1);
	}
	
	private void quickSort(Comparable[] a, int low, int high) {
		qSteps++;
		if (high <= low) return;
		int j = partition(a, low, high);
		quickSort(a, low, j-1);
		quickSort(a, j+1, high);
	}
	
	private int partition(Comparable[] a, int low, int high) {
		int i = low, j = high + 1;
		Comparable v = a[low];
		while(true) {
			while(less(a[++i], v)) if (i == high) break;
			while(less(v, a[--j])) if (j == low) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
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
