/**
 * 
 */
package com.siglelist;


/**
 * @author Ritam
 *
 */
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList2 list = new LinkedList2();
		list.head = new LinkedList2.Node(2);
		list.head.next =  new LinkedList2.Node(4);
		list.head.next.next =  new LinkedList2.Node(6);
		list.head.next.next.next =  new LinkedList2.Node(7);
		list.traverse();
		list.head = list.reverse(list.head);
		list.traverse();
		

	}

}
class LinkedList2{
	Node head;
	
	static class Node {
		Node next;
		int data;
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node(int data) {
			super();
			this.data = data;
		}
		
		
	}
	public void traverse(){
		Node x = this.head;
		while(x != null){	
			System.out.println(x.data);
			x = x.next;
		}		
	}
	public Node reverse(Node node){
		Node prev = null;
		Node current = node;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
}
