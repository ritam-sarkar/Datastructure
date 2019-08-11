package pkg.problems;

import pkg.problems.FindSubTree.Tree.Node;

public class FindSubTree {

	public static void main(String[] args) {

		Tree t1 = createParentTree();
		Tree t2 = createSubTree();
        System.out.println(isSubTree(t1.root,t2.root));	
        
		
		
	}
	
	private static  boolean isSubTree(Tree.Node parentRoot, Tree.Node childRoot) {	
		
		if(childRoot == null) {
			return true;
		}
		if(parentRoot == null) {
			return false;
		}
		if(isIdentical(parentRoot, childRoot)) {
			return true;
		}
		return isSubTree(parentRoot.left, childRoot) || isSubTree(parentRoot.right, childRoot);
	}

	private static boolean isIdentical(Node parent, Node child) {
		
		if(parent == null && child == null) {
			return true;
		}
		if(parent == null || child == null) {
			return true;
		}
		return (parent.data == child.data) && isIdentical(parent.left, child.left) && isIdentical(parent.right, child.right);
	}

	private static Tree createParentTree() {
		Tree t = new Tree();
		t.root = new Tree.Node(10);
		t.root.left = new Tree.Node(20);
		t.root.right = new Tree.Node(30);
		t.root.left.left = new Tree.Node(40);
		t.root.left.right = new Tree.Node(50);
		t.root.right.left = new Tree.Node(31);
		t.root.right.right = new Tree.Node(32);
		t.root.left.left.left = new Tree.Node(15);
		t.root.left.left.right = new Tree.Node(16);
		t.root.left.left.left.right = new Tree.Node(19);
		t.root.left.left.right.left = new Tree.Node(17);
		return t;
	}
	
	private static Tree createSubTree() {
		
		Tree t = new Tree();
		t.root = new Tree.Node(20);
		t.root.left = new Tree.Node(40);
		t.root.right = new Tree.Node(50);
		t.root.left.left = new Tree.Node(15);
		t.root.left.right = new Tree.Node(16);
		//t.root.left.left.right = new Tree.Node(19);
		//t.root.left.right.left = new Tree.Node(17);
		
		return t;
	}

	static class Tree{
		Node root;
		static class Node{
			int data;
			Node left;
			Node right;
			public Node(int data) {
				super();
				this.data = data;
			}		
		}		
	}

}
