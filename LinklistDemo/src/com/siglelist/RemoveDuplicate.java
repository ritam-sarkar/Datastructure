package com.siglelist;

import java.util.HashSet;
import java.util.Set;

import com.siglelist.LinkedList.Node;

public class RemoveDuplicate {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(1);
		list.head.next = new LinkedList.Node(2);
		list.head.next.next = new LinkedList.Node(3);
		list.head.next.next.next = new LinkedList.Node(2);
		list.head.next.next.next.next = new LinkedList.Node(2);
		list.head.next.next.next.next.next = new LinkedList.Node(4);
		list.head.next.next.next.next.next.next = new LinkedList.Node(4);
		list.removeDuplicate(list.head);
		list.printList(list.head);

		

	}
	static class LinkedList {
		static Node head;
		static class Node{
			int data;
			Node next;
			Node(int data){
				this.data = data;
			}		
		}
		public void printList(Node node){
			while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
		}
		public void removeDuplicate(Node node) {
			Set<Integer> set = new HashSet<Integer>();
			Node prev = null;
			while(node != null) {
				if(set.add(node.data)) {
					if(prev != null) {
						prev.next = node;
					}
					prev = node;
					node = node.next;
				}else {
					Node garbage = node;
					node = node.next;
					if(garbage.next == null) {
						prev.next = null;
					}else {
						garbage.next = null;
					}
				}
			}
		}
		
	}	

}
