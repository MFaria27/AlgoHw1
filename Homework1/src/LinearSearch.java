
public class LinearSearch {
	public int lSteps;
	
	public LinearSearch () {
		
	}
	
	public int search (int key, int[] a) {
		//Initialize the key, which will be the int that will be searched for, and the array it will look through.
		for (int i = 0; i < a.length; i++) {
			lSteps++; //The steps count will incease every time a value is compared to the key.
			if(a[i] == key) return i; //If the current value is the key, return the space it was found. If not, check the next value.
		}
		return -1; //If nothing is found, the function will return -1, which is an invalid array input.
	}
}

