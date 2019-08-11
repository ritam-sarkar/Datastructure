/**
 * 
 *   1               
   /   \              
  3     2               
       / \               
      5   4  
 
                                   
     1
   /   \
  2     3
 / \
4   5                                       

https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/
 * 
 * 
 */
package pkg.binary;

/**
 * @author Ritam
 *
 */
public class MirrorBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
       Node a = new Node(1);
       Node b = new Node(1);
       a.left = new Node(2);
       a.right = new Node(3);
       a.left.left = new Node(4);
       a.left.right = new Node(5);

       b.left = new Node(3);
       b.right = new Node(2);
       b.right.left = new Node(5);
       b.right.right = new Node(4);
       
       System.out.println(areMirror(a, b));
       
		
		
	}
	private static boolean areMirror(Node a,Node b){
		
		if(a == null && b == null){
			return true;
		}else if( (a== null && b != null) || (b== null && a != null)){
			return false;
		}
		else{
			return a.data == b.data && areMirror(a.left,b.right) && areMirror(a.right, b.left);
		}
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


