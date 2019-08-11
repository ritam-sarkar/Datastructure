package com.practice;


public class FlattenLinkedListPractice {

	public static void main(String[] args) {

		int[] arr1 = {5,8,9,16};
		int[] arr2 = {10,12,14,19};
		int[] arr3 = {15,23,25};
		int[] arr4 = {20,29};
		ProblemLinkedList linkedList = new ProblemLinkedList();
		ProblemLinkedList.Node head1 = linkedList.insert(null,arr1,0);
		ProblemLinkedList.Node head2 = linkedList.insert(null,arr2,0);
		ProblemLinkedList.Node head3 = linkedList.insert(null,arr3,0);
		ProblemLinkedList.Node head4 = linkedList.insert(null,arr4,0);
		linkedList.root = head1;
		linkedList.root.right = head2;
		linkedList.root.right.right = head3;
		linkedList.root.right.right.right = head4;
		linkedList.root = linkedList.flatten(linkedList.root);
		linkedList.parse();
		
		
		
		
	}
	static class ProblemLinkedList{
		
		static Node root;
		static class Node{
			 int data;
			 Node next;
			 Node right;
			public Node(int data) {
				super();
				this.data = data;
			}
			
		}
		
		public Node insert(Node curr, int[] arr, int i) {
			if(i== arr.length) {
				return null;
			}else {
				curr = new Node(arr[i]);
				curr.next = insert(curr.next,arr,i+1);
				return curr;
			}			
		}
		public Node flatten(Node node) {
			if(node.right != null) {
				node.right = flatten(node.right);
			}
			return merge(node,node.right);
		}
		private Node merge(Node x, Node y) {
			if(x == null) {
				return y;
			}else if(y == null) {
				return x;
			}else {
			    if(x.data < y.data) {
			    	x.next = merge(x.next,y);
			    	return x;
			    }else {
			    	y.next = merge(x, y.next);
			    	return y;
			    }
			}
			
		}
		
		private static void parse() {
			Node node = root;
			while(node != null) {
				System.out.print(" "+node.data);
				node = node.next;
			}
			
		}
	}

}
