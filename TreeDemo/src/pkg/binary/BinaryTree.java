/**
 * 
 */
package pkg.binary;

import pkg.binary.BinaryTree.Counter;
import pkg.binary.BinaryTree.Node;

/**
 * @author Ritam
 *
 */
public class BinaryTree {

	protected Node root;
	
	public class Node
    {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
	class Counter{
		int k;
		public Counter(int k){
			this.k = k;
		}
	}
	public int findKthSmallest(int k){
		Counter c = new Counter(k);
		return findKthSmallest(root,c);
	}
	public int findKthLargest(int k){
		Counter c = new Counter(k);
		return findKthLargest(root,c);
	}    
	public void printInorder(){
    	inorder(root);
    }
	public void printPreorder(){
		preOrder(root);
	}
    private void preOrder(Node node) {
		if(node == null){
			return;
		}
		System.out.println(node.key);
		preOrder(node.left);
		preOrder(node.right);		
	}
	private void inorder(Node node) {
    	if(node == null){
    		return;
    	}
    	inorder(node.left);
    	System.out.println(node.key);
    	inorder(node.right);    	
	}
    /**
     * Inorder
     * Left root right
     * @param curr
     * @param c
     * @return
     */
    private int findKthSmallest(Node curr,Counter c){
    	Node node = curr;
    	int kSmallest=Integer.MIN_VALUE;
    	if(node != null){
    		if(node.left != null){
        		kSmallest = findKthSmallest(node.left, c);
        	}
    		if(kSmallest == Integer.MIN_VALUE){
    			c.k--;
            	if(c.k==0){
            		kSmallest = node.key;    	
            	}	
    		}
    		if(kSmallest == Integer.MIN_VALUE){
    			if(node.right != null){
            		kSmallest = findKthSmallest(node.right, c);
            	}
    		}        	
    	}    	
    	return kSmallest;    	
    }
    /**
     * Right root left traversal
     * @param curr
     * @param c
     * @return
     */
    private int findKthLargest(Node curr, Counter c) {
    	Node node = curr;
    	int kLargest = Integer.MAX_VALUE;
    	if(node != null){
    		if(node.right != null){
    			kLargest = findKthLargest(node.right,c);
    		}
    		if(kLargest == Integer.MAX_VALUE){
    			c.k--;
    			if(c.k == 0){
    				kLargest = node.key;
    			}
    		}
    		if(kLargest == Integer.MAX_VALUE){
    			kLargest = findKthLargest(node.left,c);
    		}
    	}
		return kLargest;
	}
	public void insert(int item){
    	root = insert(root,item);    	
    }
	public void delete(int item){
		root = delete(root,item);
	}
	protected Node delete(Node curr, int item) {
        Node node = curr;
        if(node != null){
        	if(item < node.key){
        		node.left =  delete(node.left, item);
        	}else if(item > node.key){
        		node.right =  delete(node.right,item);
        	}else{
        		if(node.left == null){
        			node = node.right;
        		}else if(node.right == null){
        			node = node.left;
        		}else{
        			node.key = minVal(node.right);
        			node.right = delete(node.right, node.key);
        		}
        		return node;
        	}
        }
        return node;
	}
	private int minVal(Node curr) {
		Node node = curr;
		while(node.left!=null){
			node = node.left;
		}
		return node.key;
	}
	public Node search(int item){
		return search(root,item);
	}
	private Node search(Node curr,int item){
		Node node = curr;
		Node result = null;
		if(node.key == item){
			result =  node;
		}else if(result == null && item < node.key && node.left!= null){
		    result = search(node.left, item);
		} else if(result == null && item > node.key && node.right != null){
			result = search(node.right, item);
		}
		return result;
	}
	protected Node insert(Node curr, int item) {		
		if(curr == null){
			curr = new Node(item);
		}
		if(item < curr.key){
			curr.left = insert(curr.left,item);
		}else if(item > curr.key){
			curr.right = insert(curr.right,item);
		}
		return curr;		
	}

}
