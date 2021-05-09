/**
 * 
 */
package com.queue;

/**
 * @author Ritam
 *
 */
public class SimpleQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyQueue<Integer> q = new MyQueue<Integer>(new Integer[3]);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println("size of queue is "+q.size());
		q.enqueue(3);
		System.out.println("size of queue is "+q.size());

		System.out.println("remove "+q.dequeue());
		System.out.println("remove "+q.dequeue());
		System.out.println("size of queue is "+q.size());

		System.out.println("remove "+q.dequeue());
		System.out.println("size of queue is "+q.size());

		// empty error
		q.dequeue();

	}

}
class MyQueue<T> {
	private T[] arr;
	private int front =-1;
	private int rear =-1;
	private int capacity;

	public MyQueue(T[] arr){
		this.arr = arr;
		this.capacity = this.arr.length;
	}
	public void enqueue(T item){
		if(isFull()){
			throw new IllegalStateException(" Queue full cannot insert");
		}
		if(isEmpty()){
			front = 0;
			rear = 0;
		} else {
			rear++;
		}
		this.arr[rear] = item;
		if(isFull()){
			System.out.println("Queue is full now");
		}
	}
	public T dequeue(){
		if(isEmpty()){
			throw new IllegalStateException("Queue empty");
		}		
		T data =  this.arr[front];
		if(front == rear){
			front = -1;
			rear = -1;
		} else{
			front = front+1;
		}
		if(isEmpty()){
			System.out.println("Queue is empty now");
		}
		return data;
	}
	public int size(){
		if(isEmpty()){
			return 0;
		} else {
        return rear-front+1;
		}
	}
	public boolean isFull(){
		return rear == capacity-1;
		
	}
	
	public boolean isEmpty(){
		if(front ==-1 && rear == -1){
			return true;
		}
		return false;
		
	}
	
	
	
}
