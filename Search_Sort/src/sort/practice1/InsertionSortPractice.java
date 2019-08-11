package sort.practice1;

import util.Utility;

public class InsertionSortPractice {

	public static void main(String[] args) {

		int arr[] = {2,7,4,1,5,3};
		int n = arr.length;
		for(int i=1;i<n;i++) {
			int val = arr[i];
			int hole =i;
			while(hole>0 && arr[hole-1]>val) {
				// shifting from left to right
				arr[hole] = arr[hole-1];
				hole--;
			}
			arr[hole] = val;			
		}
		Utility.print(arr);
	}

}
