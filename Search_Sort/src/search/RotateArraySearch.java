package search;
/**
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * @author ritsarka
 *
 */
public class RotateArraySearch {

	public static void main(String[] args) {

		int arr[] = {4,5,1,2,3};
		System.out.println(search(arr, 0,arr.length-1,4));
		
	}
	private static int search(int arr[], int start, int end, int k) {
		int mid = (start+end)/2;
		if(arr[mid] == k) {
			return mid;
		}
		// if left is sorted
		if(arr[start]<=arr[mid]) {
			if(k<= arr[mid] && k >= arr[start]) {
				return search(arr, start, mid-1, k);
			}else {
				return search(arr, mid+1, end, k);
			}
		}
		// if left is not sorted right is definitely sorted
		if(k <= arr[end] && k >= arr[mid]) {
			return search(arr, mid+1, end, k);
		}
		// if not in right sorted array then left unsorted array
		return search(arr, start, mid-1, k);
	}
	

}
