package pkg.binary;

public class AvlTreeDemo {

	public static void main(String[] args) {
		AvlTree avlTree = new AvlTree();
		avlTree.insert(10);
		avlTree.insert(14);
		avlTree.insert(19);	
		avlTree.insert(27);
		//avlTree.insert(35);
		//avlTree.insert(31);
		//avlTree.insert(42);
		/*avlTree.delete(35);
		avlTree.delete(31);
		avlTree.delete(42);
		avlTree.delete(19);*/
		
		System.out.println(avlTree.root);	

	}

}
