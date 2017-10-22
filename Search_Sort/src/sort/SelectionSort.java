/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class SelectionSort {
	
	public void sort(int [] arr){
		int n = arr.length;
		for(int i =0;i<n;i++){
			
			for(int j = i+1;j<n;j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
	}
	public void sort2(int [] a){
		for(int i=0;i<a.length;i++){
			int minVal = a[i];
			int j,minIndex = i;
			for(j=i+1;j<a.length;j++){
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
