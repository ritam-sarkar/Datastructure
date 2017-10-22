/**
 * 
 */
package com.problem;

import com.problem.MergeTwoSortedList.LinkList;
import com.problem.MergeTwoSortedList.LinkList.Node;

/**
 * @author Ritam
 *
 */
public class InsertInSortedLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkList list = new LinkList();
		list.root = list.new Node(2);
		list.root.next = list.new Node(4);
		list.root.next.next = list.new Node(6);
		list.root.next.next.next = list.new Node(8);
		list.printList();
		list.insertInSortedList(3);
		System.out.println();
		list.printList();
		
		
		
		
		
		
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
		public void insertInSortedList(int item){
			Node node = root;
			Node prev = null;
			Node newNode = new Node(item);
			if(node != null){				
				while(node != null && item >= node.data){
					prev = node;
					node = node.next;
				}	
				newNode.next = node;
				if(prev !=  null){
					prev.next = newNode;					
				}else{
					root = newNode;
				}
		    }
						
		}
		public void printList(){
	    	Node node = root;
	    	while(node != null){
	    		System.out.print(node.data+" -> ");
	    		node = node.next;
	    	}
	    }
	
	}

}
