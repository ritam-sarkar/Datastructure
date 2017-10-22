/**
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 */


package com.problem;


public class FlattenLinkedList {

	public static void main(String[] args) {
          
		ProblemLinkedList mainList = new ProblemLinkedList();
		int[] arr1 = {5,8,9,16};
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
		System.out.println(mainList.root);
		
		
		
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
		Node node = null;
		if(x.data < y.data){
			node = x;
			node.next = merge(x.next,y);				
		}else{
			node = y;
			node.next = merge(x,y.next);
		}
		return node;
				
		
	}
	
	
	
	
}