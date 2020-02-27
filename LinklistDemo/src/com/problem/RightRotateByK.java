package com.problem;
/**
 * Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * @author ritsarka
 *
 */
public class RightRotateByK {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head = rotateRight(head, 1);
		ListNode node = head;
		while(node != null) {
			System.out.println(node.val);
			node = node.next;			
		}
	}
	
    public static ListNode rotateRight(ListNode head, int k) {
                 
    	ListNode last = head; 
    	int n =0;
    	while(last != null && last.next != null) {
    		n++;
    		last = last.next;
    	}
    	if(n == 0) {
    		return head;
    	}else {
    		n = n+1;
    	}
    	if(n <= k) {
    		k = k %n;
    	}
    	if(k == 0) {
    		return head;
    	}
    	k = n-k;
    	ListNode node = head;    	
    	ListNode prev = null;
    	while(k > 0) {
    		prev = node;
    		node = node.next;
    		k--;    		
    	}
    	last.next = head;
    	prev.next = null;
    	return node;        
    }

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	

}
