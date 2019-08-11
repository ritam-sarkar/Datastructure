/**
 * 
 */
package com.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


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
		q.enqueue(3);
		System.out.println("remove "+q.dequeue());
		q.dequeue();
		q.dequeue();
		
	}

}
class MyQueue<T> {
	private T[] arr;
	private int front =-1;
	private int rear =-1;
	private int capacity;
	private int size=0;
	
	public MyQueue(T[] arr){
		this.arr = arr;
		this.capacity = this.arr.length;
	}
	public void enqueue(T item){
		if(isFull()){
			throw new IllegalStateException(" Queue full cannot insert");
		}
		else if(isEmpty()){
			this.front =0;
			this.rear =0;
		}else{
			this.rear++;			
		}	
		this.arr[this.rear] = item;
		if(isFull()){
			System.out.println("Queue is full now");
		}
		this.size++;
	}
	public T dequeue(){
		if(isEmpty()){
			throw new IllegalStateException("Queue empty");
		}		
		T data =  this.arr[front];
		this.front++;
		this.size--;
		if(isEmpty()){
			System.out.println("Queue is empty now");
		}
		return data;
	}
	public int size(){
		return this.size;
	}
	public boolean isFull(){
		if(this.rear == this.capacity-1){
			return true;
		}
		return false;
		
	}
	
	public boolean isEmpty(){
		if(this.front ==-1 && this.rear == -1){
			return true;
		} else if(this.front > this.rear){
			return true;
		}
		return false;
		
	}
	
	
	
}
