/**
 * 
 */
package com.problem;

import com.problem.InsertInSortedLinkList.LinkList.Node;

/**
 * @author Ritam
 *
 */
public class DeleteANode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkList list = new LinkList();
		list.root  = list.new Node(1);
		list.root.next = list.new Node(2);
		list.root.next.next = list.new Node(3);
		list.root.next.next.next = list.new Node(4);
		list.root.next.next.next.next = list.new Node(5);
		list.root.next.next.next.next.next = list.new Node(7);
		//list.printList();
		list.delete(1);
		list.printList();
		
		
	}
	static class  LinkList{

		Node root;
		class Node{
			Node next;
			int data;
			public Node(int data) {
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
		public void delete(int item){
			Node node = root;
			Node prev =node;
			while(node.data != item) {
				prev = node;
				node = node.next;
			}
			if(prev.data == node.data) {
			    root = node.next;			    
			}else {
				prev.next = node.next;
			}
			
		}
		
	

	}

}
