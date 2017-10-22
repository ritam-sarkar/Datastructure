/**
 * 
 */
package pkg.problems;

import pkg.binary.BinaryTree;

/**
 * @author Ritam
 *
 */
public class ProblemSet1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      BinaryTree binaryTree = new BinaryTree();
      binaryTree.insert(20);
      binaryTree.insert(19);
      binaryTree.insert(22);
      binaryTree.insert(17);
      binaryTree.insert(15);
      binaryTree.insert(54);
      binaryTree.insert(21);
      binaryTree.insert(23);
      System.out.println(binaryTree.sumLeafNodes(binaryTree.getRoot()));
      
	}

}
