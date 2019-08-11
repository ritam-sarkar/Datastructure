/**
 * 
 */
package com.doublelist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

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
		/*LinkedList<Integer> link = new LinkedList<Integer>();
		link.add(1);
		link.add(2);
		link.add(3);
		link.add(4);
		link.add(5);
		link.add(6);*/		
		//int n = link.size();
		/*System.out.println("middle ement from normal linked list "+link.get(n/2)); */
		myList.addLast(1);
		myList.addLast(2);
		myList.addLast(3);
		myList.addFirst(0);
		myList.addFirst(-1);
		myList.add(5, 4);
		myList.addLast(5);
		System.out.println("size "+myList.size());
		/*System.out.println("last element "+myList.getLast());
		System.out.println("first element "+myList.getFirst());
		System.out.println("at index 2 "+myList.get(2));
		System.out.println(" middle element "+myList.findMiddleElement());
		System.out.println(" last 3rd element "+myList.find3rdLastElement());*/
		myList.traverse();
		System.out.println(myList.remove() + " after removal size "+myList.size());
		myList.traverse();
		System.out.println(myList.removeLast() + " after removal size "+myList.size());
		myList.traverse();
		System.out.println(myList.remove(2) + " after removal size "+myList.size());
		myList.traverse();

	}

}
class DoublyList<T>{
	
	private Node<T> first;
	private Node<T> last;
	private int modcount;
	private int size;
	
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
		this.size++;
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
		this.size++;
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
	public T removeFirst() {
		if(this.first == null) {
			throw new NoSuchElementException();
		}
		return unLinkFirst(this.first);
	}
	private T unLinkFirst(Node<T> f) {
		Node<T> next = f.next;
		T data = f.data;
		this.first = next;
		f.data = null;
		f.next = null;
		if(this.first == null) {
			this.last = null;
		}else {
			this.first.prev = null;
		}
		size--;
		modcount++;
		return data;
	}
	public T removeLast() {
		if(this.last == null) {
			throw new NoSuchElementException();
		}
		return unLinkLast(this.last);
	}
	public T remove() {
		return removeFirst();
	}
	public T remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
		Node<T> node = node(index);
		T data = node.data;
		Node<T> previous = node.prev;
		Node<T> next = node.next;
		if(previous == null) {
			this.first = node.next;
		}else {
			previous.next = node.next;
		}
		if(next == null) {
			this.last = null;
		}else {
			next.prev = node.prev;
		}		
		node.data = null;
		node.next = null;
		node.prev = null;
		size--;
		modcount++;
		return data;
	}
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
	private T unLinkLast(DoublyList<T>.Node<T> l) {
		
		Node<T> previous = this.last.prev;
		T data = this.last.data;
		this.last = previous;
		l.data = null;
		l.prev = null;
		if(this.last == null) {
			this.first = null;
		}else {
			this.last.next = null;
		}
		size--;
		modcount++;
		return data;
	}
	private void linkBefore(T item, Node<T> node) {
		Node<T> currNode = new Node<T>(node.prev(),node,item);
		node.setPrev(currNode);
		this.size++;
		this.modcount++;
		
	}
	private void linkLast(T item) {
		Node<T> currNode = new Node<T>(this.last,null,item);
		this.last.setNext(currNode);
		this.last = currNode;
		this.size++;
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
	public void traverse() {
		if(this.first != null) {
			Node<T> node = this.first;
			while(node != null) {
				System.out.print(node.data +" ");
				node = node.next;
			}
			System.out.println();
		}
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
		return this.size;
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
