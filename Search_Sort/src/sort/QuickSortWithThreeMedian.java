package sort;


public class QuickSortWithThreeMedian {

	public static void main(String[] args) {

		int arr[] = {10, 23 , 12, 9, 11, 4, 5, 27, 18, 1, 3};
		quicksort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	private static void quicksort(int[] arr,int start, int end) {
		if(start > end) {
			return;
		}
		
		int mid = (start+end)/2;
		if(arr[start] > arr[end]) {
			swap(arr,start,end);
		}
		if(arr[start] > arr[mid]) {
			swap(arr,start,mid);
		}
		if(arr[mid] > arr[end]) {
			swap(arr,end,mid);
		}
		swap(arr,mid,end);
		int pivot = arr[mid];
		int partIndex = partition(arr, pivot, start, end);
		quicksort(arr, start, partIndex-1);
		quicksort(arr, partIndex+1, end);
		
	}
	
	
	private static int partition(int[] arr, int pivot, int start, int end) {
	   
	   int p = start;
	   int q = end;
	   int mid = (start+end)/2;
	   while(q>p) {
		   if(arr[p]<pivot) {
			   p++;
		   }
		   if(arr[q]>pivot) {
			   q--;
		   }
		   if(arr[p] >= pivot && arr[q]<=pivot) {
			   swap(arr, p, q);
			   p++;
			   q--;
		   }
	   }
	   return q;
	}
	
     
	private static void swap(int arr[], int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}


