/**
 * http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
 */
package com.problem;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import com.problem.ProblemLinkedList.Node;

/**
 * @author Ritam
 *
 */
public class FlattenLinkedList2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};
        LinkList mainList = new LinkList();
        
        LinkList.Node head1 = mainList.createHead(arr1);
        LinkList.Node head2 = mainList.createHead(arr2);
        LinkList.Node head3 = mainList.createHead(arr3);
        LinkList.Node head4 = mainList.createHead(arr4);
        LinkList.Node head5 = mainList.createHead(arr5);
        LinkList.Node head6 = mainList.createHead(arr6);
        LinkList.Node head7 = mainList.createHead(arr7);
        LinkList.Node head8 = mainList.createHead(arr8);
        
        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;
        
        mainList.root = head1;
        Queue<LinkList.Node> childList = new ArrayDeque<LinkList.Node>();
        mainList.horizon(mainList.root, childList);
        //System.out.println(mainList.root);
        mainList.printList();
        
        
        
	}

}
class LinkList {
	Node root;
	class Node{
		 int data;
		 Node next;
		 Node child;
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	public Node createHead(int[] arr){
		Node head = null;
		head = insert(head,arr,0);
		return head;
	}
	private Node insert(Node curr, int[] arr, int i) {
		Node node = curr;	    
	    if(i<arr.length){
	    	node = new Node(arr[i]);
	    	node.next = insert(node.next,arr,i+1);
	    }	
	    return node;
	}
	
    public Node horizon(Node curr,Queue<Node> childList){
    	Node node = curr;    	
    	if(node != null){
    		if(node.child != null){
        		childList.add(node.child);
        	}
    		if(node.next == null){
    			if(!childList.isEmpty()){
    				node.next = horizon(childList.remove(),childList);
    				node.child = null;
    			}    			
    		}else{
    			node.next = horizon(node.next,childList);
    			node.child = null;
    		}
    		
    	}
    	return node;    	
    } 
    public void printList(){
    	Node node = root;
    	while(node != null){
    		System.out.print(node.data+" -> ");
    		node = node.next;
    	}
    }
    
	
}
