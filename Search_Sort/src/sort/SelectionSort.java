/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class SelectionSort {
	
	
	public void sort(int [] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int minVal = a[i];
			int j,minIndex = i;
			for(j=i+1;j<n;j++){
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
