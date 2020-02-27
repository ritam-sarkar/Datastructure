package search;

public class UbiquitousBinarySerach {

	public static void main(String[] args) {

		int arr[] = {2, 5, 6, 8, 10, 12};
		System.out.println(findFloorIndex(arr, 9));
		System.out.println(findCeilIndex(arr, 9));
	}
	
	static int findFloorIndex(int arr[], int key){
		
		int l = 0;
		int r = arr.length-1;
		int resultIndex = -1;
		
		while(l <=r) {
			int mid = (l+r)/2;
			if(arr[mid] <= key) {
				resultIndex = mid;
				l = mid+1;
			}else if(arr[mid] > key) {
				r = mid-1;
			}
			
		}
		return resultIndex;
		
	}
	
	static int findCeilIndex(int arr[], int key) {
		int l = 0;
		int r = arr.length-1;
		int resultIndex = -1;
		
		while(l <=r) {
			int mid = (l+r)/2;
			if(arr[mid] < key) {
				l = mid+1;
			}else if(arr[mid] >= key) {
				resultIndex = mid;
				r = mid-1;
			}
			
		}
		return resultIndex;
	}
	

}

