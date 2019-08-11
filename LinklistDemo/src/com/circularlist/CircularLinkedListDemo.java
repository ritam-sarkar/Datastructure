/**
 * 
 */
package com.circularlist;

/**
 * @author ritsarka
 *
 */
public class CircularLinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>(6);
		circularLinkedList.insertAtBegin(2);
		circularLinkedList.insertAtBegin(1);
		circularLinkedList.insertAtEnd(3);
		circularLinkedList.insertAtEnd(4);
		/*circularLinkedList.deleteAtBegin();
		circularLinkedList.deleteAtBegin();
		circularLinkedList.deleteAtEnd();*/
		System.out.println(" length "+circularLinkedList.size());
		//circularLinkedList.deleteAtBegin();
		circularLinkedList.insertAfter(4, 5);
		circularLinkedList.delete(3);
		circularLinkedList.traverse();
	}
	
	static class CircularLinkedList<T>{
		private Node<T> last;
		private int len;
		private int MAX;
		class Node<T>{
			private T data;
			private Node<T> next;
			public T data() {
				return data;
			}
			public void setData(T data) {
				this.data = data;
			}
			public Node<T> next() {
				return next;
			}
			public void setNext(Node<T> next) {
				this.next = next;
			}
			public Node(T data) {
				super();
				this.data = data;
			}	
			
		}
		
		
		public CircularLinkedList(int capacity) {
			super();
			MAX = capacity;
		}
		
		public void deleteAtEnd() {
			if(last == null) {
				System.out.println("Empty list");
			}else {
				Node delete = last;
				Node next = last.next;
				Node prev = null;
				while(next != null) {
					prev = next;
					next = next.next;
					if(next == last) {
						prev.next = null;
						last = prev;
						delete.next = null;
						delete.data = null;
						len--;
						break;
					}
				}
			}
		}

		public void deleteAtBegin() {
			if(last == null) {
				System.out.println("Empty list");
			}else if(len == 1){
				deleteEmpty();
			}else {				
				Node delete = last.next;				
				last.next = delete.next;
				delete.next = null;
				delete.data = null;
				len--;

			}
		}
		public void delete(T key) {
			if(last ==  null) {
				System.out.println("Empty list");
			}
			if(len ==1) {
				last.next = null;
				last.data = null;
				last = null;
			}else {
				Node node = last.next;
				Node prev = last;
				do {
					if(node.data.equals(key)) {
						Node next = node.next;
						prev.next = next;
						node.data = null;
						node.next = null;
						if(node == last) {
							last = prev;
						}
						break;
					}
					prev = node;
					node = node.next;
				}while(node != null && node != last.next);	
			}
					
			
		}

		public void insertAtBegin(T item) {
			Node<T> temp = null;
			if(last == null) {
				addToEmpty(item);
			}else {
				if(len < MAX) {
					temp = new Node(item);
					temp.next = last.next;
					last.next = temp;
					len++;	
				}
			}			
		}
		public void insertAtEnd(T item) {
			Node<T> temp = null;
			if(last == null) {
				addToEmpty(item);
			}else {
				if(len < MAX) {
					temp = new Node(item);
					temp.next = last.next;
					last.next = temp;
					last = temp;
					len++;
				}
			}
		}
		
		public void insertAfter(T data,T item) {
			Node<T> newNode = new Node(item);
			Node node = last.next;
			do {
				if(node.data.equals(data)) {
					newNode.next = node.next;
					node.next = newNode;
					if(node == last)
					  last = newNode;					
				}
				node = node.next;
			}while(node != null && node != last.next);			
			
		}
		public void traverse() {
			if(len == 0) {
				System.out.println("Empty list");
			}else {
				Node node = last.next;
				while(node != null && node != last) {
					System.out.print(node.data+" ");
					node = node.next;
				}
				System.out.print(last.data);
				System.out.println();
			}
			
		}
		private void addToEmpty(T item){
			if(last == null) {
				last = new Node(item);
			}
			last.next = last;
			len++;
		}
		private void deleteEmpty() {
			last.next = null;
			last.data = null;
			len--;
		}
		public int size() {
			return this.len;
		}
		
		
	}

}
