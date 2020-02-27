/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 */
package pkg.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ritam
 *
 */
public class CompleteBinaryTree {

	private Node root;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,7,8};
		CompleteBinaryTree bt1 = new CompleteBinaryTree();
		bt1.root = bt1.insertLevelOrder(arr, 0);
		System.out.println(bt1.isCompleteBT());
		CompleteBinaryTree bt2 = new CompleteBinaryTree();
		bt2.root = new Node(1);
		bt2.root.left = new Node(2);
		bt2.root.right = new Node(3);
		bt2.root.right.left = new Node(5);
		bt2.root.right.right = new Node(9);
		System.out.println(bt2.isCompleteBT());
		
		
		

	}
	public boolean isCompleteBT(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean flag = false;
		while(!queue.isEmpty()){
			Node temp = queue.remove();
			if(temp.left != null){
				if(flag)
					return false;
				queue.add(temp.left);
			}else{
				flag = true;
			}
			if(temp.right != null){
				if(flag)
					return false;
				queue.add(temp.right);
			}else{
				flag = true;
			}
		}
		return true;
		
	}
	static class Node{
	  Node left;
	  Node right;
	  int key;
	  public Node(int key) {
		super();
		this.key = key;
	  }	  
	}
	 Node insertLevelOrder(int[] arr,int i){
		Node node = null;
		if(i<arr.length){
			node = new Node(arr[i]);
			node.left = insertLevelOrder(arr,(2*i)+1);
			node.right = insertLevelOrder(arr,(2*i)+2);			
		}
		return node;	
		
	}
	
	

}
