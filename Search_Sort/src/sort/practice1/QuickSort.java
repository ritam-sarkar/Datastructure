/**
 * 
 */
package sort.practice1;

/**
 * @author ritsarka
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {10,16,8,12,15,6,3,9,5};
		sort(arr,0,arr.length-1);
		 for(int i=0;i<arr.length;i++) {
	        	System.out.print(arr[i]+" ");
	     }
	}

	private static void sort(int[] arr, int low, int high) {
		
		
		if(low < high) {
			int pIndex = partition(arr,low,high);
			sort(arr,low,pIndex-1);
			sort(arr,pIndex+1,high);
		}
		
	}

	private static int partition(int[] arr,int low,int high) {
		int pivot = arr[low];
		int p=  low;
		int q = high;
		while(p<=q) {
			if(arr[p]<=pivot) {
				p++;
			}
			if(arr[q]> pivot) {
				q--;
			}			
			if(arr[p]>pivot && arr[q]<pivot && p<q) {
				int temp = arr[p];
				arr[p] = arr[q];
				arr[q] = temp;
			}			
			
		}
		int temp = arr[low];
		arr[low] = arr[q];
		arr[q] = temp;
		return q;		
	}

}
