/**
 * 
 */
package com.problem;

/**
 * @author ritsarka
 * https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 *
 */
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkList list = new LinkList();
		int[] arr = {1,2,2,3,4,5,5,5,7};
		list.insert(arr);
		list.printList();
		list.removeDuplicate();
		list.printList();
	}
	
	static class LinkList {
		Node head;
		class Node{
			int data;
			Node next;
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
		void removeDuplicate() {
			Node current = head;
			Node next = current.next;
			while(current.next != null) {
				if(current.data == next.data) {
					next = next.next;
				}else {	
					current.next = next;
					current = current.next;
				}
			}
		}
	}

}
