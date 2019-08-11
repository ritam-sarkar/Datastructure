/**
 * 
 */
package com.circularlist;

/**
 * @author ritsarka
 *
 *         https://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
 */
public class SplitTwoHalves {
	public static void main(String args[]) {
		CircularLinklist<Integer> circularLinklist = new CircularLinklist<Integer>();
		circularLinklist.head = circularLinklist.new Node<Integer>(1);
		circularLinklist.head.next = circularLinklist.new Node<Integer>(2);
		circularLinklist.head.next.next = circularLinklist.new Node<Integer>(3);
		circularLinklist.head.next.next.next = circularLinklist.new Node<Integer>(4);
		//circularLinklist.head.next.next.next.next = circularLinklist.new Node<Integer>(5);
		circularLinklist.head.next.next.next.next= circularLinklist.head;
		circularLinklist.len = 4;
		circularLinklist.printList(circularLinklist.head);
		circularLinklist.splitTwoHalves();
		circularLinklist.printList(circularLinklist.head1);
		circularLinklist.printList(circularLinklist.head2);

	}

	static class CircularLinklist<T> {
		Node<T> head;
		Node<T> head1;
		Node<T> head2;
		Node<T> head1End;
		Node<T> head2End;
		int len;

		class Node<T> {
			Node<T> next;
			T data;

			public Node(T data) {
				super();
				this.data = data;
			}

		}

		public void printList(Node headPtr) {
			Node node = headPtr;
			do {
				System.out.print(node.data + " ");
				node = node.next;
			} while (node != null && node != headPtr);
			System.out.println();
		}

		public void splitTwoHalves() {
			int count = len;
			Node node = head;
			do {
				if (len - count == count || len - count == count + 1) {
					if (head2 == null)
						head2 = node;
					head2End = node;

				} else {
					if (head1 == null)
						head1 = node;
					count--;
					if (len - count == count || len - count == count + 1) {
						head1End = node;
					}
				}
				node = node.next;
			} while (node != head);
			head1End.next = null;
			head2End.next = null;
			head = null;
					

		}

	}

}
