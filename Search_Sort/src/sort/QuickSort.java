/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class QuickSort {
	
	public static void main(String args[]){
		QuickSort qs = new QuickSort();
		int a[] = {7,8,2};
		qs.sort(a,0,a.length-1);
		System.out.println(a);
	}
	public void sort(int[] arr,int start, int end){
		
	if(start < end){
		int partionIndex = partition2(arr,start,end);
		sort(arr,start,(partionIndex-1));
		sort(arr,(partionIndex+1),end);
	}
		
	}
	private int partition(int[] arr, int start, int end){
		
		int pivot = arr[end];
		int partIndex = start;
		for(int i = start ; i< end;i++){
			// i counter find value less than pivot, if found then swap with partIndex
			if(arr[i]<= pivot){
				int temp = arr[i];
				arr[i] = arr[partIndex];
				arr[partIndex] = temp;
				// after swaping increament partIndex
				partIndex++;
			}
		}
		int temp = arr[end];
		arr[end] = arr[partIndex];
		arr[partIndex] = temp;
		return partIndex;
	}
	private int partition2(int[] arr,int start,int end){
		int pivot = arr[start];
		int partIndex = end;
		for(int i = start+1 ; i<= end;i++){
			// i counter find value greater than pivot, if found then swap with partIndex
			if(arr[i]>= pivot){
				int temp = arr[i];
				arr[i] = arr[partIndex];
				arr[partIndex] = temp;
				// after swaping decreament partIndex
				partIndex--;
			}
		}
		int temp = arr[start];
		arr[start] = arr[partIndex];
		arr[partIndex] = temp;
		return partIndex;
		
	}
	private void swap(int arr[],int p,int q){
		int temp = arr[p];
		arr[p] = arr[q];
		arr[q]=temp;
	}

}
