/**
 * 	Given a binary tree, you have to print level order traversal of the tree (left child then right child) but every next level has to be printed in next line.
Example:
If the given tree is

				5

	10					15

56		47			12		42 

Then the output should be
5
10 15
56 47 12 42
 * 
 * 
 */
package pkg.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ritam
 *
 */
public class LevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       Node root = new Node(5);
       root.left = new Node(10);
       root.right = new Node(15);
       root.left.left = new Node(56);
       root.left.right = new Node(47);
       root.right.left = new Node(12);
       root.right.right = new Node(42);
       root.left.left.left = new Node(60);
       root.left.left.right = new Node(6); 
       root.right.left.left = new Node(11);
       root.right.left.right = new Node(13); 
       
       BinTree binTree = new BinTree();
       binTree.root = root;
       binTree.printLevelOrder();
       binTree.printReverseLevelOrder2();
       
		
	}

}
class BinTree{
	Node root;
	
	public void printLevelOrder() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size() >0) {
			Node node = q.poll();
			System.out.print(node.key+" ");
			if(node.left != null) {
			   q.add(node.left);
			}
			if(node.right != null) {
			   q.add(node.right);
			}
			
		}
	}
	
	// This method cannot print in proper order
	public void printReverseLevelOrder(){
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		q.add(root);
		while(q.size() >0) {
			Node node = q.poll();
			s.add(node);
			if(node.left != null) {
			   q.add(node.left);
			}
			if(node.right != null) {
			   q.add(node.right);
			}
			
		}
		System.out.println();
		while(!s.isEmpty()) {
			System.out.print(s.pop().key+" ");
		}
		
	}
	public void printReverseLevelOrder2() {
		int level = height(root);
		System.out.println();
		for(int i=level;i>0;i--) {
			printReverse(root,i);
		}
		
	}
	
	private void printReverse(Node node, int level) {
        if(node == null) {
        	return;
        }
		if(level ==0) {
			System.out.print(node.key+" ");
		}else if(level >0) {
			printReverse(node.left, level-1);
			printReverse(node.right, level-1);
		}
		
	}

	int height(Node curr){
		Node node = curr;
		int h =0;
		if(node != null){
			if(node.left != null || node.right != null){			
				h = 1+ max(height(node.left),height(node.right));
			}			
		}
		return h;		
	}
	int height(){
		return height(root);		
	}
	int max(int a, int b){
		return a>=b? a:b;
	}
}
class Node {
	Node left;
	Node right;
	int key;
	public Node(int key) {
		super();
		this.key = key;
	}		
}
