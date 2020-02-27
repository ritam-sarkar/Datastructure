/**
 *  https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
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
		//list.swapNode(51, 10);
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
    public void swapNode(int x, int y) {
       Node nodeX = null;
       Node nodeY = null;
       Node node = first;
       while(node != null) {
    	   if(node.data == x)
    		   nodeX = node;
    	   if(node.data == y)
    		   nodeY = node;
       }
       nodeX.data = y;
       nodeY.data = x;
       
       /*Node nodeXPrev = null;
       Node nodeYPrev = null;
       Node prev = null;
       Node node = first;
       while(node != null) {
    	   if(node.data == x) {
    		   nodeX = node;
    		   nodeXPrev = prev;
    	   }
    	   if(node.data == y) {
    		   nodeY = node;
    		   nodeYPrev = prev;
    	   }
    	   if(nodeX != null && nodeY != null) {
    		   break;
    	   }
    	   prev = node;
    	   node = node.next;
       }
       if(nodeXPrev == null) {
    	   this.first = nodeY;   
       }else {
    	   nodeXPrev.next = nodeY; 
       }
       if(nodeYPrev == null) {
    	   this.first = nodeX;
       }else {
           nodeYPrev.next = nodeX;
       }
       Node Xnext = nodeX.next;
       Node Ynext = nodeY.next;
       nodeY.next = Xnext;
       nodeX.next = Ynext; */      
       
    }
	
	
}