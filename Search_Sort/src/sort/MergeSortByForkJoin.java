/**
 * 
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author Ritam
 *
 */
public class MergeSortByForkJoin {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MergeSortByForkJoin demo = new MergeSortByForkJoin();
		int[] a = {3,5,2,7,9,11,17};
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		MergeSort mergeSort = demo.new MergeSort(a);
		/** process 1 : execute, invoke and join()
		 *  process 2 :  submit, future or join()
		 *  process 3 : invoke and join
		 */
		//forkJoinPool.execute(mergeSort);
		Future<int[]> future = forkJoinPool.submit(mergeSort);
		while(!mergeSort.isDone()){
			System.out.println("level of parellelism "+forkJoinPool.getParallelism());
			System.out.println(" no of active threads "+forkJoinPool.getActiveThreadCount());
			System.out.println(" no of steal count "+forkJoinPool.getStealCount());
		}
		forkJoinPool.shutdown();
		//System.out.println(mergeSort.join());
		System.out.println(future.get());
		
		

	}
	class MergeSort extends RecursiveTask<int[]>{

		private int[] unsortedArr;
		public MergeSort(int[] unsortedArr){
			this.unsortedArr = unsortedArr;
		}
		@Override
		protected int[] compute() {
			// Divide this unsorted array 
			if(unsortedArr.length == 1){
				return unsortedArr;
			}
			int[] arr1 = Arrays.copyOfRange(unsortedArr, 0, unsortedArr.length/2);
			int[] arr2 = Arrays.copyOfRange(unsortedArr,unsortedArr.length/2,unsortedArr.length);
			MergeSort task1 = new MergeSort(arr1);
			MergeSort task2 = new MergeSort(arr2);
			// assign two divided arrays to two subtasks
			// by fork or invokeAll , both will spawn a new subtasks
			//invokeAll(task1,task2);
			task1.fork();
			task2.fork();
			int[] mergedArr = new int[unsortedArr.length];
			// merge to sorted array
			merge(task1.join(),task2.join(),mergedArr);
			return mergedArr;
			
		}
		// arr1 and arr2 in the arguments are two sorted array
		private void merge(int[] arr1, int[] arr2, int[] mergedArr) {
			int i=0,j=0,k=0;
			while(i<arr1.length && j< arr2.length){
				if(arr1[i]<arr2[j]){
					mergedArr[k] = arr1[i];
					i++;
				}else{
					mergedArr[k] = arr2[j];
                    j++;
				}
				k++;				
			}
			if(i == arr1.length){
				for(int p = j;p<arr2.length;p++){
					mergedArr[k] = arr2[p];
					k++;
				}
			}else if(j == arr2.length){
				for(int p = i;p<arr1.length;p++){
					mergedArr[k] = arr1[p];
					k++;
				}
			}
		}
		
	}

}
