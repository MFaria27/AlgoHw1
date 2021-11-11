import edu.princeton.cs.algs4.StdOut;

public class BubbleSort {
	public int bSteps;
	
	public BubbleSort() {
		
	}
	
	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				bSteps++;
				if(less(a[j+1], a[j])) {
					exch(a, j, j+1);
				}
			}
		}
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
