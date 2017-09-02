/**
 * 
 */
package com.queue;

/**
 * @author Ritam
 *
 */
public class StackUsingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MyStack stack = new MyStack(new Integer[3]);
      stack.push(1); 
      stack.push(2);
      stack.push(3);
      System.out.println("popped element "+stack.pop());
      System.out.println("popped element "+stack.pop());
      
		
	}

}

class MyStack<T> {
	
	private T[] arr;
	private MyQueue<T> q1;
	private MyQueue<T> q2;
	public MyStack(T[] arr){
		this.arr = arr;
		this.q1 = new MyQueue<T>(arr);
		this.q2 = new MyQueue<T>(arr);
	}
	public void push(T item){
		this.q1.enqueue(item);
	}
	public T pop(){
		while(this.q1.size()>1){
			this.q2.enqueue(this.q1.dequeue());
		}
		T data = this.q1.dequeue();
		MyQueue<T> temp = this.q1;
		this.q1= this.q2;
		this.q2 = temp;		
		return data;
		
	}
	
}





