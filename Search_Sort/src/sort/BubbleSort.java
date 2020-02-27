/**
 * 
 */
package sort;

import util.Utility;

/**
 * @author Ritam
 *
 */
public class BubbleSort {
	
	public static void main(String args[]) {
		int arr[] = {2, 8, 7, 6, 5, 11};
		sort(arr);
		Utility.print(arr);
	}
	
	public static void sort(int[] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			boolean flag = false;
			for(int j =0;j<n-i-1;j++){
				if(arr[j+1]< arr[j]){
					int temp = arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					flag = true;
				}				
			}
			if(!flag) {
				break;
			}
		}
	}

}
