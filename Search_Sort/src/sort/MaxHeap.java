/**
 * 
 */
package sort;

/**
 * @author Ritam
 *
 */
public class MaxHeap {

	int arr[];
	int n;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = {2,7,4,1,5,3};
		MaxHeap maxHeap = new MaxHeap(arr,6);
		maxHeap.maxHeap();
		maxHeap.print();
		maxHeap.clear();
		System.out.println();
		maxHeap.insert(10);
		maxHeap.insert(8);
		maxHeap.insert(11);
		maxHeap.insert(19);
		maxHeap.print();
		System.out.println("Delete "+maxHeap.delete());
		maxHeap.print();
		
		//int maxHeapArr[] = {50, 45, 22, 24, 21, 27, 15, Integer.MIN_VALUE, 16, Integer.MIN_VALUE, Integer.MIN_VALUE, 20, 10, 11};
	}
	public MaxHeap(int[] arr, int n) {
		this.arr = arr;
		this.n = n;
	}
	private  void maxHeap(){		
		for(int i=n-1; i>=0; i--) {
			if(!isLeaf(i, n)) {
				maxHeapify(i,n);
			}
		}		
	}
	private void clear() {
		this.n =0;
		this.arr = new int[100];
	}
	private void maxHeapify(int i, int n) {

		int leftIndex = 2*i+1;
		int rightIndex = 2*i+2;
		if(leftIndex >= n) {
			return;
		}
		int left = arr[leftIndex];
		int right = rightIndex < n ? arr[rightIndex] : Integer.MIN_VALUE;
		if(arr[i] < left || arr[i]< right) {
			int swapIndex = left > right ? leftIndex : rightIndex;
			swap(i, swapIndex);
			maxHeapify(swapIndex, n);
		}
		
	}
	private boolean isLeaf(int i, int n) {
	  	return 2*i+1 >= n;
	}
	
	public  void swap(int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
	
	void insert(int item) {
		int pos = n;
		arr[pos] = item;
		n++;
		balanceAfterInsert(pos);
	}
	private void balanceAfterInsert(int i) {

		if(i == 0) {
			return;
		}
		int parent = i/2;
		if(arr[i] > arr[parent]) {
			swap(i, parent);
			balanceAfterInsert(parent);			
		}		
	}
	private int delete() {
		int del = arr[0];
		swap(0,n-1);
		n--;
		maxHeapify(0, n);
		return del;
	}
	private void print() {
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
