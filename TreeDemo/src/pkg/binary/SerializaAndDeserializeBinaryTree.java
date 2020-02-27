package pkg.binary;

import java.util.ArrayList;
import java.util.List;

public class SerializaAndDeserializeBinaryTree {

	public static void main(String[] args) {

		Node head = new Node(10);
		head.left = new Node(5);
		head.right = new Node(20);
		head.left.left = new Node(3);
		head.left.right = new Node(8);
		head.left.right.left = new Node(7);
		List<Integer> list = new ArrayList<Integer>();
        serialize(head, list);
        System.out.println(list);
        head = deserialize(list, new Counter());
        list = new ArrayList<Integer>();
        serialize(head, list);
        System.out.println(list);
        
	}
	private static Node deserialize(List<Integer> list, Counter c) {
		Integer data = list.get(c.count);
		Node node = new Node(data);
		if(data == null) {
			return node;
		}
		c.count = c.count+1;
		node.left = deserialize(list, c);
		c.count = c.count+1;
		node.right = deserialize(list, c);		
		return node;
	}
	private static void serialize(Node node, List<Integer> list) {
		if(node == null) {
			list.add(null);
			return;
		}
		list.add(node.data);
		serialize(node.left, list);
		serialize(node.right, list);		
	}
	static class Node {
		Integer data;
		Node left;
		Node right;
		Node(Integer data){
			this.data = data;
		}		
	}
	static class Counter{
		int count=0;
	}

}
