package ss;

public class ReverseSum {
	public static void main(String[]args) {
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		int midPosition=0;
		int low=0;
		int high= arr.length-1;
		
		if(arr.length%2==0) {
			midPosition=((low+high)/2)+1;
		}else {
			midPosition=(low+high)/2;
		}
		int i=0;
		while(i<midPosition) {
			int temp= arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
			System.out.println(arr[i]+" "+arr[i+1]);
			i=i+2;
		}
		
		int k=midPosition;
		while(k<arr.length-2) {
			System.out.println(k);
			int sum= arr[k]+arr[k+1];
			arr[k+1]=sum;
			k=k+2;
			}
		
		//printing array
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");
		}
		
		System.out.println();
	}

}
