/**
 * 
 */
package com.problem;

import java.util.HashSet;
import java.util.Set;

import com.problem.PlaindromeCheck.LinkList.Node;

/**
 * Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
    Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10
   
 *  https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 * @author Ritam
 *
 */
public class IntersectionUnion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {2,5,7,8,10,12};
		int[] arr2 = {2,8,12,9,15};
		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
		list1.insert(arr1);
		list2.insert(arr2);
		LinkList list3 = list1.intersection(list2);
		System.out.println(list3);
		list3 = list1.union(list2);
		System.out.println(list3);
		
		
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
		public void push(int item){			
			if(root == null){
				root = new Node(item);
			}else{				
				Node newNode = new Node(item);
				newNode.next = root;
				root = newNode;				
			}			
		}
		public void insert(int[] arr){
			root = insert(root,arr,0);
		}
		public LinkList intersection(LinkList list2){
			Node node1 = this.root;
			Node node2 = list2.root;
			LinkList list3 = new LinkList();
			Set<Integer> set = new HashSet();
			while(node1 != null && !set.contains(node1.data)){	
				set.add(node1.data);
				node1 = node1.next;				
			}
			while(node2 != null && set.contains(node2.data)){	
				list3.push(node2.data);
				node2 = node2.next;				
			}
			return list3;			
		}
		public LinkList union(LinkList list2){
			Node node1 = this.root;
			Node node2 = list2.root;
			LinkList list3 = new LinkList();
			Set<Integer> set = new HashSet();
			while(node1 != null && !set.contains(node1.data)){	
				set.add(node1.data);
				list3.push(node1.data);
				node1 = node1.next;

			}
			while(node2 != null && !set.contains(node2.data)){	
				set.add(node2.data);
				list3.push(node2.data);
				node2 = node2.next;					
			}		
			return list3;
			
		}
		
		
		
		
		
	}

}
