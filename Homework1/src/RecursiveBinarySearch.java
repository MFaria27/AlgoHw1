
public class RecursiveBinarySearch {
	public int rSteps;
	
	public RecursiveBinarySearch () {
		
	}
	
	public int search (int key, int[] a){
		//Initialize the key, which will be the int that will be searched for, and the array it will look through.
		//The low point will be the first value and the high point will be the last.
        return recursiveBinarySearch(key, a, 0, a.length - 1);
    }

    public int recursiveBinarySearch (int key, int[] a, int low, int high){
    	//Steps will be tracked every time a search is made through the array.
    	rSteps++;
    	if (low > high) return -1; //If the low point is greater than the high point, either something failed, or nothing was found.
    	//The binary search will calculate the mid point in between the high and low point.
    	//If this mid point is less than the key's value, the algorithm will search again through the low point and the mid point.
    	//If this mid point is greater than the key's value, the search will be in between the mid point and the high point.
    	//This will continue until the mid point is equal to the key.
        int mid = low + (high - low) / 2; 
        //The function will be recursively calling itself, inputing the smaller arrays until it finds the key, to which it will return the key all the way up the chain of recursive calls.
        if(key < a[mid]) return recursiveBinarySearch(key, a, low, mid -1); 
        else if (key > a[mid]) return recursiveBinarySearch(key, a, mid + 1, high);
        else return mid;
    }
}
