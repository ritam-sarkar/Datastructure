package pkg.binary;


public class MakeMirror {

	public static void main(String[] args) {

		BinaryTree binTree = new BinaryTree();
		binTree.root = new BinaryTree.Node(12);
		binTree.root.left = new BinaryTree.Node(4);
		binTree.root.right = new BinaryTree.Node(15);
		binTree.root.left.left = new BinaryTree.Node(3);
		binTree.root.left.right = new BinaryTree.Node(7);
		binTree.root.right.right = new  BinaryTree.Node(18);
		
		binTree.makeMirror(binTree.root);
		System.out.println();
		
		
	}
	static class BinaryTree{
		
		Node root;
		static class Node{
			int data;
			Node left;
			Node right;
			Node(int data){
				this.data = data;
			}			
		}
		
		public Node makeMirror(Node node) {
			
			if(node != null) {
				Node left = makeMirror(node.left);
				Node right = makeMirror(node.right);
				node.left = right;
				node.right = left;
			}
			return node;
		}

		
	}

}
