package sort.practice1;

public class MergeSort {

	public static void main(String[] args) {

		int arr[] = {2,10,4,6,9,7,11};
        sort(arr);
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
		
	}
	private static void merge(int[] a, int[] b,int c[]) {
		int i=0;
		int j =0;
		int k=0;
		while(i<a.length && j<b.length && k < c.length) {
			if(a[i]<=b[j]) {
				c[k] = a[i];
				i++;
			}else if(b[j]<a[i]) {
				c[k] = b[j];
				j++;
			}
			k++;
		}
		while(i<a.length) {
			c[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length) {
			c[k] = b[j];
			j++;
			k++;
		}
	}
	private static void sort(int[] arr) {
		int n = arr.length;
		if(n==1)
		 return;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for(int i=0;i<mid;i++) {
			left[i] = arr[i];
		}
		for(int i=mid;i<n;i++) {
			right[i-mid] = arr[i];
		}
		sort(left);
		sort(right);
		merge(left, right,arr);
	}
	
	

}
