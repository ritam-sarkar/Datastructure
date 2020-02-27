/**
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
package sort.application;

import util.Utility;

public class SortOfThreeNumbers {

	public static void main(String[] args) {

		int arr[] = {0,1,2,0,1,2};
		int arr2[] = {1,1, 2,2, 0, 0 ,1};
		sortZeroOneTwo(arr);
		Utility.print(arr);
	}

	private static void sortZeroOneTwo(int[] arr) {

		int l = 0;
		int h = arr.length -1;
		int mid =0;
		while(mid <= h) {
			switch(arr[mid]) {
			    case 0 :
			    	Utility.swap(arr, l, mid);
			    	l++;
			    	mid++;
			    	break;
			    case 1 :
			    	mid++;
			    	break;
			    case 2 :
			    	Utility.swap(arr, mid, h);
			    	h--;
			    	break;
			}
		}
	}

}
