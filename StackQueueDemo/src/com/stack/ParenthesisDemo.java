/**
 * 
 */
package com.stack;

import java.util.Stack;

/**
 * @author Ritam
 *
 */
public class ParenthesisDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       String s = "}hkhk }{()}[lkll]";
       boolean result = isProper(s);
       System.out.println(result);
       
	}

	private static boolean isProper(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(c == '{' || c == '(' || c == '['){
				stack.push(c);
			}else if(c == '}' || c == ')' || c == ']'){
				if(stack.isEmpty()){
					return false;
				}
				char ch = stack.pop();
				if(ch == '{' && c == '}'){
					continue;
				}else if(ch == '(' && c == ')'){
					continue;
				}else if(ch == '[' && c == ']'){
					continue;
				}else{
					return false;
				}
				
			}else{
				continue;
			}
		}
		return true;
	}

}
