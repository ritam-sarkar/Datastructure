package com.problem;

import com.problem.ConsonantVowelSegregate.LinkList.Node;

public class DeleteAlternateNode {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		int [] arr = {1,2,3,4,5,6,7,8,9};
		list.insert(arr);
		list.printList();
		list.alternateDelete();
		System.out.println(list);
		list.printList();
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
		public void printList(){
			Node node = root;
			while(node != null) {
				System.out.print(node.data+"  ");
				node = node.next;
			}
			System.out.println();
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
			
			// Delete from second node
			Node node = root;			
			Node prev = node;
			node = node.next;
			while(node != null && prev != null){
				prev.next = node.next;
				prev = prev.next;
				if(prev != null)
					node = node.next.next;				
			}
			
			// Delete from first node
			/*Node node = root;
			Node prev = null;
			while(node != null && node.next != null) {
				Node next = node.next;
				if(prev != null) {
					prev.next = next;
					prev = next;
				}else {
					prev = next;
					root = prev;
				}
				prev = next;
				Node removeNode = node;
				node = node.next.next;
				removeNode.next = null;				
			}
			prev.next = null;*/
			
			
		}
	}

}
