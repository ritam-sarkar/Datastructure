package com.siglelist;

/**
 * Given a linked list, swap every two adjacent nodes Given 1->2->3->4, You may not modify the values in the list's nodes, only nodes itself may be changed
 * should return the list as 2->1->4->3.
 * 
 * @author ritsarka
 *
 */
public class SwapByPair {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		head = swapPairs(head);
		System.out.println(head);
	}

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		ListNode next = second.next;
		second.next = first;
		first.next = swapPairs(next);
		head = second;		
		return head;
		
	}
	

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

}
