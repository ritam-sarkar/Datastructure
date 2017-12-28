package com.problem;

public class DeleteAlternateNode {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		int [] arr = {1,2,3,4,5,6,7,8,9};
		list.insert(arr);
		list.alternateDelete();
		System.out.println(list);
	}
	static class LinkedList{
		
		Node root;
		class Node{
			int data;
			Node next;
			public Node(int data) {
				super();
				this.data = data;
			}
			public Node() {
				super();
			}
			public int getData() {
				return data;
			}
			public void setData(int data) {
				this.data = data;
			}
			public Node getNext() {
				return next;
			}
			public void setNext(Node next) {
				this.next = next;
			}
			
		}
		void insert(int[] arr){
			Node node = null;
			for(int val : arr){
				if(root == null){
					root = new Node(val);
					node = root;
				}else{
					node.next = new Node(val);	
					node = node.next;
				}
			}
		}
		void alternateDelete(){
			Node node = root;			
			Node prev = node;
			node = node.next;
			while(node != null && prev != null){
				prev.next = node.next;
				prev = prev.next;
				if(prev != null)
					node = node.next.next;				
			}
			
		}
	}

}
