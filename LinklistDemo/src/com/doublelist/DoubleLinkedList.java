/**
 * 
 */
package com.doublelist;

/**
 * @author Ritam
 *
 */
public class DoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyList<Integer> myList = new DoublyList<Integer>();
		myList.addLast(1);
		myList.addLast(2);
		myList.addLast(3);
		myList.addFirst(0);
		myList.addFirst(-1);
		myList.add(5, 4);
		myList.addLast(5);
		System.out.println("size "+myList.size());
		System.out.println("last element "+myList.getLast());
		System.out.println("first element "+myList.getFirst());
		System.out.println("at index 2 "+myList.get(2));
		System.out.println(" middle element "+myList.findMiddleElement());
		System.out.println(" last 3rd element "+myList.find3rdLastElement());
	}

}
class DoublyList<T>{
	
	private Node<T> first;
	private Node<T> last;
	private int modcount;
	
	public void addFirst(T item){
		Node<T> currNode = new Node<T>(item);
		if(this.first == null){
			this.first = currNode;
			this.last = this.first;
		}else{
			currNode.setNext(this.first);
			this.first.setPrev(currNode);
			this.first = currNode;
		}
		this.modcount++;
	}
	public void addLast(T item){
		Node<T> currNode = new Node<T>(item);
		if(this.last == null){
			this.last = currNode;
			this.first = this.last;
		} else{
			currNode.setPrev(this.last);
			this.last.setNext(currNode);
			this.last = currNode;
		}
		this.modcount++;
	}
	
	public T getFirst(){
		if(this.first == null){
			return null;
		} else{
			return this.first.data();
		}
	}
	public T getLast(){
		if(this.last == null){
			return null;
		} else{
			return this.last.data();
		}		
	}
	public void add(int index,T item){
		if(index < 0 || index > this.modcount){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			if(index == this.modcount){
				linkLast(item);
			} else{
				linkBefore(item,node(index));
			}
		}		
	}
	private void linkBefore(T item, Node<T> node) {
		Node<T> currNode = new Node<T>(node.prev(),node,item);
		node.setPrev(currNode);
		this.modcount++;
		
	}
	private void linkLast(T item) {
		Node<T> currNode = new Node<T>(this.last,null,item);
		this.last.setNext(currNode);
		this.last = currNode;
		this.modcount++;
		
	}
	private Node<T> findMiddleNode(){		
		if(this.first == null){
			return null;
		}
		Node<T> x = this.first;		
		Node<T> y = this.first;
		while(x.next()!= null){
			x = x.next();
			if(x.next() != null){
				x = x.next();
				y = y.next();
			}
		}
		return y;		
	}
	
	public T findMiddleElement(){
		Node<T> middleNode = findMiddleNode();
		if(middleNode != null){
			return middleNode.data();
		}
		return null;
	}
	public T find3rdLastElement(){
		Node<T> x = this.first;
		Node<T> y = this.first;
		for(int i =0;i<2;i++){
			if(x.next != null){
				x = x.next;	
			}
		}
		while(x.next != null){
			x = x.next;
			y = y.next;
		}
		return y.data();
		
	}
	public T get(int index){
		return node(index).data();
	}
	private Node<T> node(int index){
		Node<T> x = null;		
		if(index < this.modcount >> 1){
			x = this.first;
			for(int i=0;i<index;i++){
				x = x.next();
			}
		}else{
			x = this.last;
			for(int i = this.modcount; i>= index ;i--){
				x = x.prev();
			}
		}		
		return x;		
	}
	public int size(){
		return this.modcount;
	}
	class Node<V>{
		private Node<V> prev;
		private Node<V> next;
		private V data;		
		
		public Node(){
			super();
		}
		public Node(V data) {
			super();
			this.data = data;
		}
		public Node(Node<V> prev,Node<V> next, V data) {
			super();
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
		public Node<V> prev() {
			return prev;
		}
		public void setPrev(Node<V> prev) {
			this.prev = prev;
		}
		public Node<V> next() {
			return next;
		}
		public void setNext(Node<V> next) {
			this.next = next;
		}
		public V data() {
			return data;
		}
		public void setData(V data) {
			this.data = data;
		}
		
	}
}
