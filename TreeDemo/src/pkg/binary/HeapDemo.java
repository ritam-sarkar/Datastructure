/**
 * 
 */
package pkg.binary;

/**
 * @author Ritam
 *
 */
public class HeapDemo {

	public static void main(String[] args){
		Heap<Integer> heap = new Heap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.get();
	}
	
	
}
class Heap<T>{
	
	private Node<T> head;
	public void insert(T item){
		if(this.head == null){
			this.head = new Node(item, null, null, null);
		}else if(this.head.left == null && this.head.right == null){
			this.head.left = new Node(item, null, null, this.head);
		}else if(this.head.left != null && this.head.right == null){
			this.head.right = new Node(item, null, null, this.head);
			this.head = this.head.left;
		}else if(this.head.left != null && this.head.right != null){
			this.head = this.head.left;
			this.head.left = new Node(item, null, null, this.head);
		}
	}
	
	public void get(){
		Node<T> rootNode = findRoot();
		if(rootNode != null){
			printVal(rootNode);
		}
	}
	private void printVal(Node<T> rootNode) {
	   System.out.println(rootNode.data);	
       if(rootNode.left != null){
    	   System.out.println(rootNode.left.data);
    	   printVal(rootNode.left);
       }
       if(rootNode.right != null){
    	   System.out.println(rootNode.right.data);
    	   printVal(rootNode.right);
       }
		
	}

	private Node<T> findRoot() {
		Node<T> x = this.head;
		if(x == null){
			return x;
		}else{
			while(x.parent != null){
				x = x.parent;
			}
			return x;
		}
	}
	class Node<V>{
		private T data;
		private Node<V> left;
		private Node<V> right;
		private Node<V> parent;
		
		public Node(T data, Node<V> left, Node<V> right, Node<V> parent) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<V> getLeft() {
			return left;
		}
		public void setLeft(Node<V> left) {
			this.left = left;
		}
		public Node<V> getRight() {
			return right;
		}
		public void setRight(Node<V> right) {
			this.right = right;
		}
		public Node<V> getParent() {
			return parent;
		}
		public void setParent(Node<V> parent) {
			this.parent = parent;
		}
		
		
	}
}
