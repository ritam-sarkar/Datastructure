/**
 * http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */

package com.problem;

public class MergeTwoSortedList {

	public static void main(String[] args) {

       int[] arr1 = {5,7,7,9};
       int[] arr2 = {4,6,8};
       MergeTwoSortedList mergeList = new MergeTwoSortedList();
       LinkList list1 = mergeList.new LinkList();
       LinkList list2 = mergeList.new LinkList();
       list1.createList(arr1);
       list2.createList(arr2);
       list1.merge(list2);
       System.out.println(list1.root);

	}
	
	class LinkList{
		Node root;
		class Node{
			Node next;
			int data;
			public Node(int data) {
				super();
				this.data = data;
			}			
		}
		public void merge(LinkList list){
			root = merge(this.root,list.root);
		}
		private Node merge(Node x, Node y) {
		   if(x == null){
			   return y;
		   }
		   if(y == null){
			   return x;
		   }
		   if(x.data < y.data){			   
			   x.next = merge(x.next, y);
			   return x;
		   }else{
			   y.next = merge(x, y.next);
			   return y;
		   }
		}
		public void createList(int[] arr){
			root = insert(root,arr,0);
		}
		private Node insert(Node node, int[] arr, int i) {
			if(i<arr.length){
				node = new Node(arr[i]);
				node.next = insert(node.next,arr,i+1);
			}
			return node;
		}
	}

}

