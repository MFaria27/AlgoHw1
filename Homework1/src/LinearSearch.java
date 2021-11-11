
public class LinearSearch {
	public int lSteps;
	
	public LinearSearch () {
		
	}
	
	public int search (int key, int[] a) {
		for (int i = 0; i < a.length; i++) {
			lSteps++;
			if(a[i] == key) return i;
		}
		return -1;
	}
}

