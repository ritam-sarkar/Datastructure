/**
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
package pkg.problems;

/**
 * @author Ritam
 *
 */
public class LCADemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		System.out.println(tree.root);
		System.out.println(tree.findLCA(tree.root, 10, 14));
		
		

	}
	static class BinaryTree{
		Node root;
		static class Node {
			Node left;
			Node right;
			int key;
			public Node(int key) {
				super();
				this.key = key;
			}		
		}	
		public void insert(int item){
			root = insert(root,item);
		}
		private Node insert(Node curr, int item) {
			Node node = curr;
			if(node == null){
				node = new Node(item);
				return node;
			}else{
				if(item < node.key){
					node.left = insert(node.left,item);
				}else{
					node.right = insert(node.right,item);
				}
			}			
			return node;
		}
		public int findLCA(Node curr,int n1,int n2){
			Node node = curr;
			if(n1 == n2){
				System.out.println("no solution n1 and n2 is equal");
				return 0;
			}
			if(node != null){
				if(node.key > n1 && node.key > n2){
					return findLCA(node.left,n1,n2);
				}else if(node.key < n1 && node.key < n2){
					return findLCA(node.right,n1,n2);
				}else{
					return node.key;
				}
			}
			System.out.println("no solution");
			return 0;
		}
		
	}

}
