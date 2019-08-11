package sort.practice1;

import util.Utility;

public class SelectionSortPractice {

	public static void main(String[] args) {
		int arr[] = {2,7,4,1,5,3};
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int minIndex = i;
			for(int j =i;j<n;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex =j;
				}
			}
			Utility.swap(arr, i, minIndex);			
		}
		Utility.print(arr);

	}

}
