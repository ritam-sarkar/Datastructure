/**
 * 
 */
package pkg.binary;

/**
 * @author Ritam
 *
 */
public class AvlTree extends BinaryTree{

	public void insert(int item){
    	root = insert(root,item); 
		//super.insert(item);
    	
    }
	public void delete(int item){
		root = delete(root,item);		
	}
	@Override
	protected Node delete(Node curr, int item) {
		Node node =  super.delete(curr, item);		
		return makeBalance(node);
	}
	private Node makeBalance(Node node) {
		int balance = getBalance(node);
		
		//Left Left case
		if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
 
		// Left Right Case
        if (balance > 1 && getBalance(node.left) < 0)
        {
        	node.left = leftRotate(node.left);
            return rightRotate(node);
        }
		// Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);                
 
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0)
        {
        	node.right = rightRotate(node.right);
            return leftRotate(node);
        }
		return node;
	}
	@Override
	protected Node insert(Node curr,int item){
		Node node = super.insert(curr, item);		
		return makeBalance(node);
		
	}	
	private Node leftRotate(Node x) {
		Node y = x.right;
		Node z = y.left;
		y.left = x;
		x.right = z;
		return y;
	}
	private Node rightRotate(Node x) {
		Node y = x.left;
		Node z = y.right;
		y.right = x;
		x.left = z;
		return y;
		
	}
	public int getBalance(Node curr){
		Node node = curr;
		int bal =0;
		if(node != null){
			int leftHeight =0;
			int rightHeight =0;
			leftHeight = node.left == null ? 0 : height(node.left)+1;
			rightHeight = node.right == null ? 0 :height(node.right)+1;
			if(node != null){
				bal =  leftHeight - rightHeight;
			}
		}		
		return bal;
	}
	public int height(Node curr) {
		int height =0;
		Node node = curr;
		if(node != null){
			if(node.left == null && node.right == null){
				height =0;
			}else{
				height = 1+max(height(node.left),height(node.right));	
			}
		}
		return height;
	}
	private int max(int a, int b) {
		return a>b ? a:b;
	}
}
