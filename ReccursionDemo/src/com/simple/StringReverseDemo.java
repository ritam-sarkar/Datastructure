/**
 * 
 */
package com.simple;

/**
 * @author Ritam
 *
 */
public class StringReverseDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1[];
		String str = "viechle";		
        System.out.println("String before reverse "+str);
        System.out.println("String after reverse "+reverse(str));
	}
	private static String reverse(String str){
		if(str.length()>1){
			return reverse(str.substring(1))+str.charAt(0);
		}else{
			return str;
		}
	}
	

}

