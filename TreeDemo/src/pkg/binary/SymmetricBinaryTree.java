/**
 * 
 *   1
   /   \
  2     2
 / \   / \
3   4 4   3
true


    1
   / \
  2   2
   \   \
   3    3
false   
 * 
 */
package pkg.binary;

/**
 * @author Ritam
 *
 */
public class SymmetricBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();	
		// TODO Auto-generated method stub
      Node a = symmetricBinaryTree.new Node(1);
      a.left = symmetricBinaryTree.new Node(2);
      a.right = symmetricBinaryTree.new Node(2);
      a.left.left = symmetricBinaryTree.new Node(3);
      a.left.right = symmetricBinaryTree.new Node(4);
      a.right.left = symmetricBinaryTree.new Node(4);
      a.right.right = symmetricBinaryTree.new Node(3);
     System.out.println(symmetricBinaryTree.isSymmetric(a)); 
		
	}
	boolean isSymmetric(Node node) {
	 	return isMirror(node.left, node.right);
		
	}
	boolean isMirror(Node a, Node b){
		if(a == null && b == null){
			return true;
		}else if( (a== null && b != null) || (b== null && a != null)){
			return false;
		}
		else{
			return a.data == b.data && isMirror(a.left,b.right) && isMirror(a.right, b.left);
		}
	}
	class  Node {
		 int data;
		 Node left;
		 Node right;
		public Node(int data) {
			super();
			this.data = data;
		}
		 
	}
	
	

}

