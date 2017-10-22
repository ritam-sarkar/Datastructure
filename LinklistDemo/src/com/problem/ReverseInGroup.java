/**
 * 
 */
package com.problem;

import com.problem.IntersectionUnion.LinkList.Node;

/**
 * @author Ritam
 *
 */
public class ReverseInGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkList list = new LinkList();
		int[] arr = {1,2,3,4,5,8,9,10};
		list.root = list.insert(list.root, arr, 0);
		list.root = list.reverseGroup(list.root,3);
		System.out.println(list.root);

	}
	static class LinkList{
		Node root;
		class Node{
			Node next;
			int data;
			public Node(int data) {
				super();
				this.data = data;
			}			
		}
		public Node insert(Node curr, int[] arr, int i) {
			Node node = curr;
			int n = arr.length;
		    if(i<n){
		    	node = new Node(arr[i]);
		    	node.next = insert(node.next,arr,i+1);
		    }	
		    return node;
		}
		public Node reverseGroup(Node curr,int k){
			Node node = curr;
			Node next = null;
			Node prev = null;
			int i =k;						
			while(node != null && i>0){
				next = node.next;
				node.next = prev;
				prev = node;				
				node = next;
				i--;
			}
			if(node != null){
				curr.next = reverseGroup(node,k);
			}
			return prev;
			
		}
	}

}
