/**
 * 
 */
package com.problem;

/**
 * @author Ritam
 *
 */
public class SwapKthElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(25);
		list.add(45);
		list.add(31);
		list.add(16);
		list.add(23);
		list.add(51);
		list.swapTwoElement(3);
		System.out.println(list);
		

	}

}
class LinkedList{
	
	Node first;
	Node last;
	int size;
	
	class Node{
		Node next;
		int data;
		public Node(int data) {
			super();
			this.data = data;
		}		
	}
	public void add(int item){
		if(this.last == null || this.first == null){			
			this.first = new Node(item);
			this.last = this.first;
		}else{
			Node newNode = new Node(item);
			this.last.next = newNode;
			this.last = this.last.next;	
		}	
		size++;
	}
	private Node findFirstKthElement(int k){
		Node node = this.first;
		while(k-1>0){
			node = node.next;
			k--;
		}
		return node;
	}
    private Node findLastKthElement(int k){
		k = size-k;
		return findFirstKthElement(k+1);
	}
    public void swapTwoElement(int k){    	
		Node x = findFirstKthElement(k);
		Node y = findLastKthElement(k);
		int xData = x.data;
		x.data = y.data;
		y.data = xData;    	
		
    }
	
	
}