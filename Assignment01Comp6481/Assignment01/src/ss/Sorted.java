package ss;

public class Sorted {
	    

	    // Function to find the sum of elements smaller and greater than x
	    public static void findSum(int[] arr, int x) {
	        int n = arr.length;
	        int xIndex = binarySearch(arr, x);

	        // Calculate sum of elements smaller than x
	        long sumSmaller = 0;
	        for (int i = 0; i < xIndex; i++) {
	            sumSmaller += arr[i];
	        }

	        // Calculate sum of elements larger than x
	        long sumLarger = 0;
	        for (int i = xIndex + 1; i < n; i++) {
	            sumLarger += arr[i];
	        }

	        System.out.println("Sum of elements smaller than " + x + ": " + sumSmaller);
	        System.out.println("Sum of elements larger than " + x + ": " + sumLarger);
	    }

	    // Binary search to find the index of x in the sorted array
	    private static int binarySearch(int[] arr, int x) {
	        int low = 0;
	        int high = arr.length - 1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            if (arr[mid] == x) {
	                return mid;
	            } else if (arr[mid] < x) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }
	        return low; // Return the index where x should be inserted
	    }

	    public static void main(String[] args) {
	        int[] arr = {3, 5, 9, 9, 10, 14, 22, 35, 64, 92};
	        int x = 9; // Example value of x
	        findSum(arr, x);
	    }
	
	}


