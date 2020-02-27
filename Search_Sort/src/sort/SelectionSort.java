/**
 * 
 */
package sort;

import util.Utility;

/**
 * @author Ritam
 *
 */
public class SelectionSort {
	
	public static void main(String args[]) {
		int arr[] = {2, 8, 7, 6, 5, 11};
		sort(arr);
		Utility.print(arr);
	}
	public static void sort(int [] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int minVal = a[i];
			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(a[j]<minVal){
					minVal = a[j];
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i]= a[minIndex];
			a[minIndex] = temp;			
		}
	}

}
