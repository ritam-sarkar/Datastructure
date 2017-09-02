package com.siglelist;
/**
 * 
 */

import java.util.LinkedList;

/**
 * @author Ritam
 *
 */
public class SingleLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       //LinkedList<String> linlist;
		MySingleList<String> myList = new MySingleList<String>();		
		myList.addFirst("A");
		myList.addLast("B");
		myList.addLast("C");
		myList.add(3, "D");
		myList.add(2,"X");
		System.out.println(" last value "+myList.getLast());
		System.out.println(" first value "+myList.getFirst());
		System.out.println(" size "+myList.size());
		System.out.println(" index 2 "+myList.get(2));
		
	}

}

class MySingleList<T> {
	private Node<T> first;
	private Node<T> last;
	private int modcount;
	public MySingleList() {
				
	}	
	public int size(){
		return this.modcount;
	}
	public void addLast(T item){
		
		Node<T> currentNode = new Node<T>(item);
		if(this.last == null){
			this.last = currentNode;
			this.first = this.last;
		} else{
			this.last.setNext(currentNode);
			this.last = currentNode;
		}		
		this.modcount++;
	}
	public void addFirst(T item){
		Node<T> currentNode = new Node<T>(item);
		if(this.first == null){
			this.first = currentNode;
			this.last = this.first;
		} else{
			Node<T> tempNode = this.first;
			this.first = currentNode;
			this.first.setNext(tempNode);
		}
		this.modcount++;
	}
	public void add(T item){
		this.addLast(item);
	}
	public void add(int index, T item){
		if(index < 0 || index > this.modcount){
			throw new ArrayIndexOutOfBoundsException();
		}else{
			if(index == this.modcount){
				linkLast(item);
			}else{
				linkMiddle(item,node(index-1),node(index));
			}
			this.modcount++;
		}
	}
	private Node<T> node(int index){
		Node<T> x = this.first;
		if(index > 0){
			for(int i =0;i<index;i++){
				x = x.next();
			}
		}				
		return x;
		
	}
	private void linkMiddle(T t,Node<T> p,Node<T> s){
		Node<T> currentNode = new Node<T>(t,s);
		p.setNext(currentNode);		
	}
	private void linkLast(T pred){
		Node<T> currentNode = new Node<T>(pred);
		if(this.last == null){
			this.last = currentNode;
			this.first = this.last;
		}else{
		    this.last.setNext(currentNode);	
		    this.last = currentNode;
		}		
	}
	public T getLast(){
		if(this.last != null){
			return this.last.data();
		}else{
			return null;
		}		
	}	
	public T getFirst(){
		if(this.first != null){
			return this.first.data();
		}else{
			return null;
		}
	}
	public T get(int index){
		return this.node(index).data();
	}
	
	class Node<V>{
		private V data;
		private Node<V> next;
		
		public Node() {
			super();
		}

		public Node(V data, Node<V> next) {
			super();
			this.setData(data);
			this.setNext(next);
		}
		
		public Node(V data) {
			super();
			this.data = data;
		}

		public V data() {
			return data;
		}
		public void setData(V data) {
			this.data = data;
		}
		public Node<V> next() {
			return next;
		}
		public void setNext(Node<V> next) {
			this.next = next;
		}
		
		
		
	}
	
}


