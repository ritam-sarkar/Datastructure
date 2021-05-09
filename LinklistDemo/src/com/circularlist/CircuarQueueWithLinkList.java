/**
 * 
 */
package com.circularlist;

import java.util.NoSuchElementException;

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
		circularQueue.enQueue(5);
		circularQueue.traverse();
		System.out.println();
		System.out.println("------------- Dequeue operation----------");
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.deQueue());
		//circularQueue.deQueue();
		circularQueue.enQueue(1);
		circularQueue.enQueue(2);
		circularQueue.traverse();
		System.out.println();
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
			if(isEmpty()) {
				rear = newNode;
				front = rear;
			} else {
				rear.next = newNode;
				rear = rear.next;
			}
			rear.next = front;
		}
		public T deQueue() {
			if(isEmpty()) {
				throw new NoSuchElementException();
			}
			T item = front.data;
			if(front == rear) {
				front = null;
				rear = null;				
			}else {
				front = front.next;
				rear.next = front;
			}
			return item;			
		}
		
		public void traverse() {
			if(front == null) {
				System.out.println(" Empty list");
			}else {
				Node node = front;
				do {
					System.out.print(node.data);
					node = node.next;
				}while(node != front);
			}
			
		}
		public boolean isEmpty() {
			return rear == null;
		}
		
	}

}
