
public class Searching {
	public int bSteps;
	public int rSteps;
	public int lSteps;
	public Searching () {
		
	}
	
	public int linearSearch (int key, int[] a) {
		for (int i = 0; i < a.length; i++) {
			lSteps++;
			if(a[i] == key) return i;
		}
		return -1;
	}
	
	public int binarySearch (int key, int[] a){
        int low = 0;
        int high = a.length-1;
        while (low <= high){
        	bSteps++;
            int mid= low + (high-low)/2;
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int recursiveBinarySearch (int key, int[] a){
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
