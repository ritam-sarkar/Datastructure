/**
 * 
 */
package com.problem;

/**
 * @author ritsarka
 *
 */
/**
 * 
Input : 2D matrix 
1 2 3
4 5 6
7 8 9

Output :
1 -> 2 -> 3 -> NULL
|    |    |
v    v    v
4 -> 5 -> 6 -> NULL
|    |    |
v    v    v
7 -> 8 -> 9 -> NULL
|    |    |
v    v    v
NULL NULL NULL
https://www.geeksforgeeks.org/construct-linked-list-2d-matrix/
 * 
 *
 */
public class LinkListFromMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {{1,2,3},
		             {4,5,6},
		             {7,8,9}};
		LinkList linkList = new LinkList();
		//linkList.createLinkList(a);
		linkList.formLinkList(a);
		linkList.traverse();

	}
	static class LinkList{
	   Node head;
	   class Node{
		   Node next;
		   Node down;
		   int data;
		public Node(int data) {
			super();
			this.data = data;
		}		   
	   }
	   public void createLinkList(int[][] a){
		   head = createLinkList(a,0,0,a.length,a[0].length);
	   }
	   public void formLinkList(int[][] a) {
		   int r = a.length;
		   int c = a[0].length;
		   Node[] heads = new Node[c];
		   for(int i=0;i<r;i++) {
			   heads[i] = null;
			   Node node = null;
			   for(int j =0;j<c;j++) {
				   if(heads[i] == null) {
					   heads[i] = new Node(a[i][j]);
				       node = heads[i];  
				   }else {
					   node.next = new Node(a[i][j]);
					   node = node.next;
				   }
			   }
		   }
		   // now create down connection
		   head = heads[0];
		   for(int i =0;i<heads.length-1;i++) {
			   Node node1 = heads[i];
			   Node node2 = heads[i+1];
			   while(node1 != null && node2 != null) {
				   node1.down = node2;
				   node1 = node1.next;
				   node2 = node2.next;
			   }
		   }
		
	   }
	private Node createLinkList(int[][] a, int i, int j, int r, int c) {
		 
		 if(i >= r || j >= c) {
			 return null;
		 }
		 Node newNode = new Node(a[i][j]);
		 newNode.next = createLinkList(a, i, j+1, r, c);
		 newNode.down = createLinkList(a, i+1, j, r, c);	
		 return newNode;
       }
	   public void traverse() {
		   display(head);
	   }
	   private void display(Node node) {
		
		   Node i = node;
		   while(i!= null) {
			   System.out.print(i.data+"  ");
			   i = i.next;
		   }
		   System.out.println();
		   if(node != null)
		    display(node.down);
	   }
	   
	}

}
