/**
 * 
 */
package com.queue;

import java.util.LinkedList;
import java.util.Queue;

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
      MyStack stack = new MyStack();
      stack.push(1); 
      stack.push(2);
      stack.push(3);
      System.out.println("popped element "+stack.pop());
      System.out.println("popped element "+stack.pop());
	  stack.push(4);
	  stack.push(5);
	  System.out.println("popped element "+stack.pop());
      System.out.println("popped element "+stack.pop());
	}

}

class MyStack<T> {
	
	private Queue<T> q;
	
	public MyStack(){		
		this.q = new LinkedList<T>();
	}
	public void push(T item){
		q.offer(item);
	}
	public T pop(){
		int size = q.size();
		while(size > 1) {
			q.offer(q.poll());
			size--;
		}
		return q.poll();	
	}
	
}





