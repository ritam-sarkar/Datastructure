package com.siglelist;

/**
 *  Delete a node where no head is given in a linked list.
 *  There is a drawback we cannot delete the last node in this case
 * @author ritsarka
 *
 */
public class DeleteWithoutHead {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		LinkedList.Node node1 = new LinkedList.Node(1);
		LinkedList.Node node2 = new LinkedList.Node(2);
		LinkedList.Node node3 = new LinkedList.Node(3);
		LinkedList.Node node4 = new LinkedList.Node(4);
		LinkedList.Node node5 = new LinkedList.Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		list.head = node1;
		list.print();
		System.out.println();
		list.delete(node4);
		list.print();
		
	}
	static class LinkedList{		
		
		Node head;
		static class Node{
			int data;
			Node next;
			Node(int data){
				this.data = data;
			}
		}
		void delete(Node node) {
			
			Node next = node.next;
			if(next != null) {
				node.data = next.data;
				node.next = next.next;
			}
		}
		void print() {
			Node node = head;
			while(node != null) {
				System.out.print(node.data+" ");
				node = node.next;
			}
		}
		
	}

}
