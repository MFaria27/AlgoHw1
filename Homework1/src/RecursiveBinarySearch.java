
public class RecursiveBinarySearch {
	public int rSteps;
	
	public RecursiveBinarySearch () {
		
	}
	
	public int search (int key, int[] a){
        return recursiveBinarySearch(key, a, 0, a.length - 1);
    }

    public int recursiveBinarySearch (int key, int[] a, int low, int high){
    	rSteps++;
    	if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if(key < a[mid]) return recursiveBinarySearch(key, a, low, mid -1);
        else if (key > a[mid]) return recursiveBinarySearch(key, a, mid + 1, high);
        else return mid;
    }
}
