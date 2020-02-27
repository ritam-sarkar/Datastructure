package com.stack;

import java.util.Stack;

public class MinimumStack2 {

	public static void main(String[] args) {
		
		MinimumStack2 stack = new MinimumStack2();
		stack.push(5);
		stack.push(10);
		stack.push(3);
		stack.push(2);
		stack.push(9);
		stack.push(1);
		System.out.println("min  "+stack.getMin());
		System.out.println("pop  "+stack.pop());
		System.out.println("pop  "+stack.pop());
		System.out.println("pop  "+stack.pop());
		System.out.println("min  "+stack.getMin());

	}
	
	Stack<Integer> s;
    int min;
    public MinimumStack2() {
        s = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public int pop() {   	
    	int top = s.pop();
    	if(top == min) {
    		min = s.pop();
    	}
    	return top;
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }

}
