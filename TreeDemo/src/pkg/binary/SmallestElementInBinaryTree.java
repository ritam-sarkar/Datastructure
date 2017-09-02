/**
 * 
 */
package pkg.binary;


/**
 * @author Ritam
 *
 */
public class SmallestElementInBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binTree = new BinaryTree();	  
		binTree.insert(50);
		binTree.insert(20);
		binTree.insert(10);
		binTree.insert(30);
		binTree.insert(70);
		binTree.insert(60);
		binTree.insert(80);
		binTree.insert(55);
		//System.out.println(binTree.findKthSmallest(2));	
		//System.out.println(binTree.findKthLargest(4));	
		//binTree.printInorder();
		//System.out.println("delete called ");
		//binTree.delete(70);
		//binTree.printInorder();
		binTree.printPreorder();
		

	}
	
}
