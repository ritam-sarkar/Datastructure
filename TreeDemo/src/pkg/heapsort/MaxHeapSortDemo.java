/**
 * 
 */
package pkg.heapsort;

/**
 * @author Ritam
 *
 */
public class MaxHeapSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap maxHeap = new MaxHeap(20);
		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.insert(5);
		maxHeap.insert(6);
		maxHeap.maxHeap();
		maxHeap.print();
		
	}

}
class MaxHeap{
	int[] heap;
	int size = 0;
	int maxSize = 0;
	public MaxHeap(int maxSize){
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
		if(leftpos > maxSize){
			return 0;
		}
		return leftpos;
	}
	private int right(int pos){
		int rightpos = (pos*2)+1;
		if(rightpos > maxSize){
			return 0;
		}
		return rightpos;
	}
	public void insert(int item){
		heap[size] = item;
		size++;	
		
	}
	private void swap(int current, int parent) {
		int temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}
	public void maxHeap(){
		for(int i=size/2;i>=1;i--){
			maxHeapify(i);
		}
	}
	private boolean isLeaf(int pos){
		if(pos > (size/2) && pos <=size){
			return true;
		}
		return false;
	}
	private void maxHeapify(int pos) {
		if(!isLeaf(pos)){
			if(heap[pos]<heap[left(pos)] || heap[pos]<heap[right(pos)]){
				if(heap[pos]<heap[left(pos)]){
					swap(pos,left(pos));				
					maxHeapify(left(pos));
				}
				if(heap[pos]<heap[right(pos)]) {
					swap(pos,right(pos));				
					maxHeapify(right(pos));
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
        System.out.println("max : "+heap[1]);
    }
	
}
