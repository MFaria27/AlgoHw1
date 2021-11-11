
public class BinarySearch {
	public int bSteps;
	
	public BinarySearch() {
		
	}
	
	public int search (int key, int[] a){
		//Initialize the key, which will be the int that will be searched for, and the array it will look through.
        int low = 0; //The lowest point of the array will be the first value of the array.
        int high = a.length-1; //The highest point of the array will be the last value.
        while (low <= high){ //If the low point is greater than the high point, either something failed, or nothing was found.
        	bSteps++; //Steps will be tracked every time a search through an array is made.
        	//The binary search will calculate the mid point in between the high and low point.
            int mid= low + (high-low)/2; 
            //If this mid point is less than the key's value, the algorithm will search again through the low point and the mid point.
            if (key < a[mid]) high = mid - 1; 
            //If this mid point is greater than the key's value, the search will be in between the mid point and the high point.
            else if (key > a[mid]) low = mid + 1;
            else return mid; //This will continue until the mid point is equal to the key.
        }
        return -1;
    }
}
