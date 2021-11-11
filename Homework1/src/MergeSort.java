import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
	private Comparable aux[];
	public int mSteps;
	
	public MergeSort() {
		
	}
	
	public void sort(Comparable[] a) {
		//Create an auxiliary array to store a copy of array
		aux = new Comparable[a.length];
		mergeSort(a, 0, a.length-1);
	}
	
	private void mergeSort(Comparable[] a, int low, int high) {
		mSteps++; //Every time Merge Sort partitions and sorts the array will count as a step. (We can also count the merging, but that's not necessarily going through the array).
		if(high <= low) return; //If the low point is greater than the high point, either something failed, or nothing was found.
		int mid = low + (high - low)/2; //Merge sort selects the mid point of the current array between the low and high points
		//The sorter will then split the array in half, and will continue to do so with both halves of the array.
		//This will recursively continue until all array values are split.
		mergeSort(a, low, mid); 
		mergeSort(a, mid+1, high); 
		//Then Merge Sort will compare each split and merge them together in the right order, and will do this recursively until the array is sorted.
		merge(a, low, mid, high);
	}

	private void merge(Comparable[] a, int low, int mid, int high) {
		int i = low, j = mid+1;
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid) a[k] = aux[j++];
			else if (j > high) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
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
