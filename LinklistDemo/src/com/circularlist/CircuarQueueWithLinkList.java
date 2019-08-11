/**
 * 
 */
package com.circularlist;

/**
 * @author ritsarka
 * https://www.geeksforgeeks.org/circular-queue-set-2-circular-linked-list-implementation/
 *
 */
public class CircuarQueueWithLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularQueue<Integer> circularQueue = new CircularQueue<Integer>();
		circularQueue.enQueue(1);
		circularQueue.enQueue(2);
		circularQueue.enQueue(3);
		circularQueue.enQueue(4);
		circularQueue.traverse();
		circularQueue.deQueue();
		circularQueue.deQueue();
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.deQueue());
		circularQueue.deQueue();
		circularQueue.enQueue(1);
		circularQueue.enQueue(2);
		circularQueue.traverse();
		System.out.println(circularQueue.deQueue());
		
		
	}
	
	static class CircularQueue<T>{
		
		Node<T> front, rear;
		class Node<T>{
			T data;
			Node<T> next;
			public Node(T data) {
				super();
				this.data = data;
			}
			
		}
		public void enQueue(T item){
			Node<T> newNode = new Node(item);
			if(front == null) {
				front = newNode;
			}else {
				rear.next = newNode;
			}	
			rear = newNode;
			rear.next = front;
		}
		public T deQueue() {
			T item = null;
			if(front == null) {
				System.out.println(" Empty queue");
				return null;
			}else if(front == rear){
				item = front.data;
				front = null;
				rear = null;				
			}else {
				item = front.data;
				rear.next = front.next;
				Node removable = front;
				front = front.next;
				removable.data = null;
				removable.next = null;
			}
			return item;
			
		}
		public void traverse() {
			if(front == null) {
				System.out.println(" Empty list");
			}else {
				Node node = front;
				do{
				  System.out.print(node.data+"  ");	
				  node = node.next;
				}while(node != front);
				System.out.println();
			}
			
		}
		
	}

}
