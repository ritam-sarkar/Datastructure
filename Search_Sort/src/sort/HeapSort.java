/**
 * 
 */
package sort;

import util.Utility;

/**
 * @author Ritam
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = {2,7,4,1,5,3};
		int n = arr.length;
		for(int i= n/2-1 ; i>=0;i--) {
			maxHeapify(arr, n , i);			
		}
		for(int i=n-1;i>=0;i--) {
			Utility.swap(arr, i,0);
			maxHeapify(arr, i, 0);
		}				
		Utility.print(arr);
	}
	private static void maxHeapify(int arr[], int n, int i){
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left < n && arr[left]>arr[largest])
			largest = left;
		if(right < n && arr[right] > arr[largest])
			largest = right;
		if(largest != i) {
			Utility.swap(arr, i, largest);
			maxHeapify(arr, n, largest);
		}
	}

}
