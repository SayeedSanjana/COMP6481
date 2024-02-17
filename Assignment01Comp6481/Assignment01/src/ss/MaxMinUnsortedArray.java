package ss;

public class MaxMinUnsortedArray {
public static void main(String[]args) {
	
	int arr[]= {10,14,3,9,22,35,92,5,9,64};
	int sumMax=0;
	int sumMin=0;
	int target=9;
	
	for(int i=0;i<arr.length;i++) {
		if(arr[i]>target) {
			sumMax=sumMax+arr[i];
		}else if(arr[i]<target) {
			sumMin=sumMin+arr[i];
		}

	}
	System.out.println(sumMin);
	System.out.println(sumMax);
  }
}
