/**
 * 
 */
package com.problem;

import com.problem.InsertInSortedLinkList.LinkList.Node;

/**
 * @author Ritam
 *
 */
public class PlaindromeCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] arr = {'R','A','D','A','R'};
		char[] arr2 = {'R','A','D','A','R','P'};
		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
		list1.root = list1.insert(list1.root, arr, 0);
		list2.root = list2.insert(list2.root, arr2, 0);
		//list1.printList();
		//list2.printList();
		System.out.println(" list1 is "+list1.isPalindrome());
		System.out.println(" list2 is "+list2.isPalindrome());

	}
	static class LinkList{


		Node root;
		public class Node{
			Node next;
			char data;
			public Node(char data) {
				super();
				this.data = data;
			}			
		}		
		public void printList(){
	    	Node node = root;
	    	while(node != null){
	    		System.out.print(node.data+" -> ");
	    		node = node.next;
	    	}
	    }
		public Node insert(Node curr, char[] arr, int i) {
			Node node = curr;
			int n = arr.length;
		    if(i<n){
		    	node = new Node(arr[i]);
		    	node.next = insert(node.next,arr,i+1);
		    }	
		    return node;
		}
		public boolean isPalindrome(){
			Node root1 = root;
			Node root2 = reverse(root);			
			while(root1 != null && root2 != null){
				if(root1.data != root2.data){
					return false;
				}else{
					root1 = root1.next;
					root2 = root2.next;
				}
			}
			return true;
			
		}
		private Node reverse(Node curr) {
			Node node = curr;
			Node prev = null;
			Node next = null;
			while(node != null){
				next = node.next;
				node.next = prev;
				prev = node;				
				node = next;
			}
			return prev;
		}
		
	

	}

}
