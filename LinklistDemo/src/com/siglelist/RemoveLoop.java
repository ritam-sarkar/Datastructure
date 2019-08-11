/**
 * 
 */
package com.siglelist;

/**
 * @author Ritam
 * Floyd algorithm https://www.youtube.com/watch?v=LUm2ABqAs1w
 * 
 * m + k = 2 * integer number
 * m = distance from start node to the first element of the loop
 * k = first element of the loop to detected node in the loop.
 *
 */
public class RemoveLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new LinkedList.Node(51);
        list.head.next = new LinkedList.Node(50);
        list.head.next.next = new LinkedList.Node(20);
        list.head.next.next.next = new LinkedList.Node(15);
        list.head.next.next.next.next = new LinkedList.Node(14);
        list.head.next.next.next.next.next = new LinkedList.Node(10);
        list.head.next.next.next.next.next.next = new LinkedList.Node(16);
        list.head.next.next.next.next.next.next.next = list.head.next.next.next.next;
        System.out.println("first element of the loop "+list.findFirstLoopElement().data);
        System.out.println(" Distance from start node to the first element of the loop "+list.countStraightength());
        System.out.println(" Count loop length "+list.countLoopLength());
        list.detectAndRemoveLoop(list.head);
        list.printList(list.head);
	}

}
class LinkedList {
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
	public void detectAndRemoveLoop(Node node){			
		Node fast = detectLoop(node);
		if(fast != null) {
			// loop exists
			Node slow = node;
			while(slow.next != fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;			
		}		
		
	}
	public Node findFirstLoopElement() {
		Node fast = detectLoop(head);
		if(fast != null) {
			Node slow = head;
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			if(slow == fast) {
				return slow;
			}
		}		
	    return null;
		
	}
	public int countStraightength() {
		Node fast = detectLoop(head);
		int count = 1;
		if(fast != null) {
			Node slow = head;
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
				count++;
			}
			if(slow == fast) {
				return count;
			}
		}
		return 0;
	}
	private Node detectLoop(Node node) {
		if(node == null || node.next == null) {
			return null;
		}
		Node slow = node;
		Node fast = node;
		
		while(fast != null && fast.next != null) {
			if(slow == fast)
				break;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		if(slow == fast) {
			System.out.println(" Loop exists");
			return fast;
		}else {
			return null;
		}
		
	}
	public int countLoopLength() {
		Node firstElement = findFirstLoopElement();
		Node node = firstElement;
		int count =1;
		while(node.next != firstElement) {
			count++;
			node = node.next;
		}
		return count;
	}
		
	
	
}
