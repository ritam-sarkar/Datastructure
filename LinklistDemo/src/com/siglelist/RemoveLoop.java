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
        System.out.println(" First node in the loop is "+ list.detectAndRemoveLoop(list.head));
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
	public int detectAndRemoveLoop(Node node){			
		Node fast = detectLoop(node);
		Node slow = node;
		if(fast != null) {
			// loop exists			
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;			
		}	
		return slow.data;
		
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
	
		
	
	
}
