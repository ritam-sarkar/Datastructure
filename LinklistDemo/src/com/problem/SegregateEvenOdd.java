/**
 * 
 */
package com.problem;

import com.problem.RemoveDuplicate.LinkList.Node;

/**
 * @author ritsarka
 *
 *https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * Input: 17->15->8->12->10->5->4->1->7->6->NULL
 * Output: 8->12->10->4->6->17->15->5->1->7->NULL
 */
public class SegregateEvenOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkList list = new LinkList();
		int[] arr = {2,4,3,6,5,1,7,8};
		list.insert(arr);
		list.printList();
		list.segregate();
		list.printList();
	}
	
	static class LinkList{
		Node head;
		class Node{
			private int data;
			private Node next;
			public Node(int data) {
				super();
				this.data = data;
			}
			
		}
		void insert(int[] arr){			
			head = new Node(arr[0]);	
			insert(head,arr,1);
			
		}
		private void insert(Node node, int[] arr, int i) {
			if(i< arr.length) {
				node.next = new Node(arr[i]);
				node = node.next;
				insert(node,arr,i+1);
			}
		}
		void printList(){
			Node node = head;
			while(node != null) {
				System.out.print(node.data+"  ");
				node = node.next;
			}
			System.out.println();
		}
		
		void segregate(){
			Node even = null;
			Node odd =  null;
			Node oddHead = null; 
			Node evenHead = null;
			Node node = head;
			while(node != null) {
				if(node.data %2 != 0) {
					if(odd == null) {
						odd = node;
						oddHead = odd;
					}else {
						odd.next = node;
						odd = odd.next;	
					}
									
				}else {
					if(even == null) {
						even = node;
						evenHead = even;
					}else {
						even.next = node;
						even = even.next;
					}					
				}
				node = node.next;
			}
			even.next = oddHead;
			odd.next = null;
			head = evenHead;
			
		}
	

	}

}

