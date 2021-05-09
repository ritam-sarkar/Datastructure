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
		System.out.println("removded item "+q.dequeue());
		//System.out.println("removded item "+q.dequeue());
		
	}

}

class CircularQueue <T>{
	private int n =0;
	private T[] Q;
	private int front;
	private int rear;
	private int elementCount =0;
	
	public CircularQueue(T[] arr){
		this.n = arr.length;
		this.front = -1;
		this.rear = -1;
		this.Q = arr;
	}
	public int size() {
		return this.elementCount;
		
	}
	public void enqueue(T item){		
		System.out.println(" inserting "+item);
		if(isFull()){
			throw new IllegalStateException("Que is full cannot insert");
		}else if(isEmpty()){
			rear =0;
			front =0;
		}else{
			rear = (rear+1)% n;
		}
		Q[rear] = item;		
		if(isFull()){
			System.out.println("The que is full now");
		}
		elementCount++;
	}
	public T dequeue(){
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty ");
		}
		T data = Q[front];
		if(front == rear) {
			front =-1;
			rear =-1;
		}else {
			front = (front+1)% n;
		}		
		elementCount--;		
		return data;
	}
	public boolean isFull(){
		if((rear+1)% n == front){
			return true;
		}
		return false;
		
	}
	public boolean isEmpty(){
		if(front ==-1 && rear == -1){
			return true;
		}
		return false;
	}	
}


