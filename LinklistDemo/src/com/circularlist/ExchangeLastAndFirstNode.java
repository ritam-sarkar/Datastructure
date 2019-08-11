/**
 * 
 */
package com.circularlist;

import com.circularlist.SplitTwoHalves.CircularLinklist.Node;

/**
 * @author ritsarka
 *
 */
public class ExchangeLastAndFirstNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularLinkList<Integer> circularLinkList = new CircularLinkList<Integer>();
		circularLinkList.head = circularLinkList.new Node<Integer>(1);
		circularLinkList.head.next = circularLinkList.new Node<Integer>(2);
		circularLinkList.head.next.next = circularLinkList.new Node<Integer>(3);
		circularLinkList.head.next.next.next = circularLinkList.new Node<Integer>(4);
		circularLinkList.head.next.next.next.next = circularLinkList.head;
		circularLinkList.printList();
		circularLinkList.exchange();
		circularLinkList.printList();	

	}
	
	static class CircularLinkList<T>{
		Node<T> head;
		class Node<T> {
			Node<T> next;
			T data;

			public Node(T data) {
				super();
				this.data = data;
			}
		}

		public void printList() {
			Node node = head;
			do {
				System.out.print(node.data + " ");
				node = node.next;
			} while (node != head);
			System.out.println();
		}
		
		public void exchange() {			
			Node p = head; 
		    while (p.next.next != head) 
		    p = p.next; 
		      
		    // Exchange first and last  
		    // nodes using head and p 
		    p.next.next = head.next; 
		    head.next = p.next; 
		    p.next = head; 
		    head = head.next; 
		  
		}

	}

}
