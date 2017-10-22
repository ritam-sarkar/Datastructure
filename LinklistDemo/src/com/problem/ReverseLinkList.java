/**
 * 
 */
package com.problem;

import com.problem.MergeTwoSortedList.LinkList;
import com.problem.MergeTwoSortedList.LinkList.Node;

/**
 * @author Ritam
 *
 */
public class ReverseLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList mainList = new LinkList();
		int[] arr = {1,3,5,7,8};
		mainList.createList(arr);
		mainList.reverse();
		mainList.printList();
		
		
		
	
	}
	static class LinkList{
		Node root;
		class Node{
			Node next;
			int data;
			public Node(int data) {
				super();
				this.data = data;
			}			
		}		
		public void createList(int[] arr){
			root = insert(root,arr,0);
		}
		private Node insert(Node node, int[] arr, int i) {
			if(i<arr.length){
				node = new Node(arr[i]);
				node.next = insert(node.next,arr,i+1);
			}
			return node;
		}		
		private void reverse() {
			Node node = root;
			Node prev = null;
			Node next = null;
			while(node != null){
				next = node.next;	
				node.next = prev;
				prev = node;
				node = next;
			}
			root = prev;
		}
		public void printList(){
	    	Node node = root;
	    	while(node != null){
	    		System.out.print(node.data+" -> ");
	    		node = node.next;
	    	}
	    }
	}


}
