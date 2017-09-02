/**
 * 
 */
package pkg.heapsort;

/**
 * @author Ritam
 *
 */
public class MinHeapSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap minHeap = new MinHeap(20);
		minHeap.insert(6);
		minHeap.insert(5);
		minHeap.insert(4);
		minHeap.insert(2);
		minHeap.insert(5);
		minHeap.insert(6);
		minHeap.minHeap();
		minHeap.print();
	}

}

class MinHeap{
	int[] heap;
	int size = 0;
	int maxSize = 0;
	public MinHeap(int maxSize){
		this.maxSize = maxSize;
		heap = new int[this.maxSize+1];
		heap[0] = Integer.MAX_VALUE;
		size++;
	}
	private int parent(int pos){
		return pos/2;
	}
	private int left(int pos){
		int leftpos = pos*2;
		
		return leftpos;
	}
	private int right(int pos){
		int rightpos = (pos*2)+1;
		
		return rightpos;
	}
	public void insert(int item){
		heap[size] = item;
		size++;
		int current = size;
		
		
	}
	private void swap(int current, int parent) {
		int temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}
	public void minHeap(){
		for(int i=size/2;i>=1;i--){
			minHeapify(i);
		}
	}
	private boolean isLeaf(int pos){
		if(pos > (size/2) && pos <=size){
			return true;
		}
		return false;
	}
	private void minHeapify(int pos) {
		if(!isLeaf(pos)){
			if((heap[pos]>heap[left(pos)] || heap[pos]>heap[right(pos)]) && heap[pos] != 0 && heap[left(pos)]!=0 && heap[right(pos)]!= 0){
				if(heap[pos]<heap[left(pos)]){
					swap(pos,left(pos));				
					minHeapify(left(pos));
				}
				if(heap[pos]>heap[right(pos)]) {
					swap(pos,right(pos));				
					minHeapify(right(pos));
				}
			}
		}		
	}
	public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i]
                  + " RIGHT CHILD :" + heap[2 * i  + 1]);
            System.out.println();
        }
        System.out.println("min : "+heap[1]);
    }
	
}