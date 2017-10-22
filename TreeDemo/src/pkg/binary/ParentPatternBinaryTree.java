/**
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 */
package pkg.binary;

import pkg.binary.CompleteBinaryTree.Node;

/**
 * @author Ritam
 *
 */
public class ParentPatternBinaryTree {

	Node root;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
       int[] arr = {1, 5, 5, 2, 2, -1, 3};
       ParentPatternBinaryTree bt = new ParentPatternBinaryTree();
       bt.createTree(arr);
       System.out.println(bt.root);
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
	public void createTree(int[] arr){
		Node created[] = new Node[arr.length];
		for(int i=0;i<arr.length;i++){
			createNode(arr,created,i);
		}
		
	}
	private void createNode(int[] parent, Node[] created, int i) {
		if(created[i] != null){
			return;
		}
		// create the new node with the parent array index, it will be used later
		created[i] = new Node(i);
		//create the root node if i is the root
		if(parent[i] == -1){
			root = created[i];
			return;
		}
		if(created[parent[i]] == null){
			// there is no parent node, create first
			createNode(parent, created, parent[i]);
		}
		//find parent node
		Node p = created[parent[i]];
		if(p.left == null){
			p.left = created[i];
		}else if(p.right == null){
			p.right = created[i];
		}
	}

}
