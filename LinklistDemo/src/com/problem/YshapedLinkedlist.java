package com.problem;
/**
 * https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 * @author ritsarka
 *
 */
public class YshapedLinkedlist {

	public static void main(String[] args) {

		Node head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(9);
		Node interSectionNode = new Node(15);
		interSectionNode.next = new Node(30);
		head1.next.next.next = interSectionNode;
		head1.next.next.next.next = new Node(30);
		Node head2 = new Node(10);
		//head2.next = new Node(15);
		head2.next = interSectionNode;
		System.out.println(getInterSection(head1,head2));
	}
	
	private static int getInterSection(Node node1, Node node2) {
		int c1 = getCount(node1);
		int c2 = getCount(node2);
		int d = Math.abs(c1-c2);
		if(c1 > c2) {
			for(int i =0;i<d;i++) {
				node1 = node1.next;
			}
		}
		if(c2 > c1) {
			for(int i =0;i<d;i++) {
				node2 = node2.next;
			}
		}
		while(node1 != null && node2 != null && node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		if(node1 != null && node2 != null) {
			return node1.data;
		}else {
			return -1;
		}
		
	}
	private static int getCount(Node node) {
		int count =0;
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}

}
