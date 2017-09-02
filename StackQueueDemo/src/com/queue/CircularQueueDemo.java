/**
 * 
 */
package com.queue;

/**
 * @author Ritam
 *
 */
public class CircularQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue q = new CircularQueue(new String[2]);
		q.enqueue("A");
		q.enqueue("B");
		System.out.println("removded item "+q.dequeue());
		q.enqueue("C");		
		System.out.println(q.size());
		System.out.println("removded item "+q.dequeue());
		
	}

}

class CircularQueue <T>{
	private int capacity =0;
	private T[] Q;
	private int front;
	private int rear;
	private int elementCount =0;
	
	public CircularQueue(T[] arr){
		this.capacity = arr.length;
		this.front = -1;
		this.rear = -1;
		this.Q = arr;
	}
	public int size() {
		return this.elementCount;
		
	}
	public void enqueue(T item){		
		
		if(isFull()){
			throw new IllegalStateException("Que is full cannot insert");
		}else if(isEmpty()){
			this.rear =0;
			this.front =0;
		}else{
			this.rear = (this.rear+1)%this.capacity;
		}
		this.Q[this.rear] = item;		
		if(isFull()){
			System.out.println("The que is full now");
		}
		this.elementCount++;
	}
	public T dequeue(){
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty ");
		}
		T data = this.Q[this.front];
		this.front = (this.front+1)%this.capacity;
		this.elementCount--;
		if(isEmpty()){
			System.out.println("This queue is empty now");
		}
		return data;
	}
	public boolean isFull(){
		if((this.rear+1)%this.capacity == this.front){
			return true;
		}
		return false;
		
	}
	public boolean isEmpty(){
		if(this.front ==-1 && this.rear == -1){
			return true;
		}
		return false;
	}
	
}


