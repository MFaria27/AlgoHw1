import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Sorting {
	private Comparable aux[];
	public int bSteps;
	public int mSteps;
	public int qSteps;
	public Sorting () {
		
	}
	
	public void bubbleSort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				bSteps++;
				if(less(a[j+1], a[j])) {
					exch(a, j, j+1);
				}
			}
		}
	}
	
	public void mergeSort(Comparable[] a) {
		aux = new Comparable[a.length];
		mergeSort(a, 0, a.length-1);
	}
	
	private void mergeSort(Comparable[] a, int low, int high) {
		mSteps++;
		//System.out.println(mSteps);
		if(high <= low) return;
		int mid = low + (high - low)/2;
		mergeSort(a, low, mid);
		mergeSort(a, mid+1, high);
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
	
	public void quickSort(Comparable[] a) {
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
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void show(Comparable[] a) {
		for (Comparable element : a)
			StdOut.print(element + " ");
		StdOut.println();
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
}
