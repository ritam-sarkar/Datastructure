/**
 * 
 */
package com.siglelist;

/**
 * @author Ritam
 *
 */
public class RemoveLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
        list.head = new LinkedList.Node(50);
        list.head.next = new LinkedList.Node(20);
        list.head.next.next = new LinkedList.Node(15);
        list.head.next.next.next = new LinkedList.Node(4);
        list.head.next.next.next.next = new LinkedList.Node(10);
        list.head.next.next.next.next.next = list.head.next.next;
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
		//for empty list or list with one element
		if (node == null || node.next == null)
            return;		
		Node slow = node;
		Node fast = node;
		slow = slow.next;
		fast = fast.next.next;
		
		//detect loop
		while(fast != null && fast.next != null){
			if(slow == fast)
				break;
			else{
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		// if loop exists
		// remove loop
		if(slow == fast){
			System.out.println("loop exists");
			slow = node;
			while(slow.next != fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}
	
}
