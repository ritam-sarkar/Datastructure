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

/**
 * @author Ritam
 *
 */
public class LavelOrderTraversal {

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
       //binTree.printLevelWise();
       //binTree.printLavelOrder();
       binTree.printReverse();
       
		
	}

}
class BinTree{
	Node root;
	
	void printLevelWise(){
		int h = height();
		for(int i=0;i<=h;i++){
			printRecc(root,i);
			System.out.println();
		}
	}	
	void printRecc(Node node,int level){		
		
		if(node == null){
			return;
		}
		if(level ==0){
			System.out.print(" "+node.key+" ");
		}else{
			printRecc(node.left, level-1);
			printRecc(node.right, level-1);
		}
	}
	public void printLavelOrder(){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);		
		while(true){
			int level = q.size();
			if(level == 0){
				break;
			}
			while(level > 0){
				Node temp = q.remove();			
				System.out.print(temp.key+" ");			
				if(temp.left != null){
					q.add(temp.left);
				}
				if(temp.right != null){
					q.add(temp.right);
				}
				level--;
			}	
			System.out.println();
		}
	}
	public void printReverseLavleTraversal(){
		
	}
	public void printReverse(){
		int height = height();
		for(int i=0;i<height;i++){
			printReverse(root,i);
			System.out.println();
		}
	}
	public void printReverse(Node node, int i){
		int h = height(node);
		if(node != null){
			if(i == h){
				System.out.print(node.key+" ");
			}else{
				printReverse(node.left,i);
				printReverse(node.right,i);
			}
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
