package com.siglelist;

import java.util.Stack;

public class PalindromeList {

	public static void main(String[] args) {

		LinkList linkList = new LinkList();
		linkList.head = new LinkList.Node(1);
		linkList.head.next = new LinkList.Node(2);
		linkList.head.next.next = new LinkList.Node(3);
		linkList.head.next.next.next = new LinkList.Node(2);
		linkList.head.next.next.next.next = new LinkList.Node(1);	
		System.out.println(linkList.isPalindrome());
		
	}
	static class LinkList{
		
		Node head;
		static class Node{
			int data;
			Node next;
			Node(int data){
				this.data = data;
			}
		}
		boolean isPalindrome() {
			
			Stack<Integer> stack = new Stack<Integer>();
			Node node = head;
			while(node != null) {
				stack.push(node.data);
				node = node.next;
			}
			Node x = head;
			while(x != null) {
				if(x.data != stack.pop()) {
					return false;
					
				}
				x = x.next;
			}
			return true;
			
		}
		
	}

}
