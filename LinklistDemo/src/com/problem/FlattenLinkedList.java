/**
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 * 
 *      
 *     5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


package com.problem;


public class FlattenLinkedList {

	public static void main(String[] args) {
          
		ProblemLinkedList mainList = new ProblemLinkedList();
		int[] arr1 = {5,7,8,30};
		int[] arr2 = {10,12,14,19};
		int[] arr3 = {15,23,25};
		int[] arr4 = {20,29};
		
		ProblemLinkedList.Node head1 = mainList.createHead(arr1);
		ProblemLinkedList.Node head2 = mainList.createHead(arr2);
		ProblemLinkedList.Node head3 = mainList.createHead(arr3);
		ProblemLinkedList.Node head4 = mainList.createHead(arr4);
		
		mainList.root = head1;
		mainList.root.right = head2;
		mainList.root.right.right = head3;
		mainList.root.right.right.right = head4;		
		System.out.println(mainList.root);
		mainList.flatten();
		mainList.printList();
		
		
		
	}

}
class ProblemLinkedList{
	
	Node root;
	class Node{
		 int data;
		 Node next;
		 Node right;
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	public Node createHead(int[] arr){
		Node head = null;
		head = insert(head, arr, 0, arr.length);
		return head;		
	}
	private Node insert(Node curr, int[] arr, int i, int n) {
		Node node = curr;	    
	    if(i<n){
	    	node = new Node(arr[i]);
	    	node.next = insert(node.next,arr,i+1,n);
	    }	
	    return node;
	}
	public void flatten(){		
		root = flatten(root);		
	}
	private Node flatten(Node curr) {
		Node node = curr;
		if(node == null || node.right == null){
			return node;
		}
		node.right = flatten(node.right);
		node = merge(node,node.right);
		node.right =null;
		return node;
	}
	public Node merge(Node x, Node y){	
		
			if(x == null){
				return y;
			}
			if(y== null){
				return x;
			}
			if(x.data < y.data) {
			  	x.next = merge(x.next, y);
			  	return x;
			} else {
				y.next = merge(x, y.next);
				return y;
			}
				
		
	}
	public void printList() {
		Node node = root;
		while(node != null) {
			System.out.println(node.data+" ");
			node = node.next;
		}
	}
	
	
	
	
}
