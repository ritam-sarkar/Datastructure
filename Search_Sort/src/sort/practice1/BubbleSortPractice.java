package sort.practice1;

import util.Utility;

public class BubbleSortPractice {

	public static void main(String[] args) {

		int arr[] = {2,7,4,1,5,3};
		int n = arr.length;
		for(int i=0;i<n;i++) {
			boolean flag = false;
			for(int j =0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					Utility.swap(arr, j, j+1);
					flag =true;
				}				
			}
			// If the array is sorted, then no need to go for the next pass
			if(!flag) {
				break;
			}
		}
		Utility.print(arr);
	}
	

}
