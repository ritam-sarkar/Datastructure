/**
 * 
 */
package com.problem;

import com.problem.SegregateEvenOdd.LinkList.Node;

/**
 * @author ritsarka
 *
 *https://www.geeksforgeeks.org/arrange-consonants-vowels-nodes-linked-list/
 *
 *Input : a -> b -> c -> e -> d -> 
        o -> x -> i
 * Output : a -> e -> o -> i -> b -> 
         c -> d -> x 
 */
public class ConsonantVowelSegregate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkList linkList = new LinkList();
	    char[] arr = {'R','i','t','S','o','m','U'};
	    char[] arr2 = {'R','t','s'};
	    linkList.insert(arr);
	    linkList.printList();
	    linkList.segregate();
	    linkList.printList();
	}
	
	static class LinkList{
		Node head;
		class Node{
			private char data;
			private Node next;
			public Node(char data) {
				super();
				this.data = data;
			}
			
		}
		void insert(char[] arr){			
			head = new Node(arr[0]);	
			insert(head,arr,1);
			
		}
		private void insert(Node node, char[] arr, int i) {
			if(i< arr.length) {
				node.next = new Node(arr[i]);
				node = node.next;
				insert(node,arr,i+1);
			}
		}
		public void printList(){
			Node node = head;
			while(node != null) {
				System.out.print(node.data+"  ");
				node = node.next;
			}
			System.out.println();
		}
		public void segregate() {
			Node node = head;
			Node vowelHead = null;
			Node vowelEnd = null;
			Node consonantHead = null;
			Node consonantEnd = null;
			while(node != null) {
				if(isVowel(node.data)) {
					if(vowelHead == null) {
						vowelHead = node;
						vowelEnd = vowelHead;
					}else {
						vowelEnd.next = node;
						vowelEnd = vowelEnd.next;
					}
				}else {
					if(consonantHead == null) {
						consonantHead = node;
						consonantEnd = consonantHead;
					}else {
						consonantEnd.next = node;
						consonantEnd = consonantEnd.next ;
					}
				}
				node = node.next;
			}
			if(vowelHead == null || vowelEnd == null) {
				head = consonantHead;
				consonantEnd.next = null;
			}else  if(consonantEnd == null || consonantHead == null){
				head = vowelHead;
				vowelEnd.next = null;
			}else {
				vowelEnd.next = consonantHead;
				consonantEnd.next = null;
				head = vowelHead;
			}
			
			
		}
		private boolean isVowel(char c) {
			c = Character.toLowerCase(c);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				return true;
			}
			return false;
		}
	}

}
