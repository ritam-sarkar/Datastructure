package com.cacahe;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo {

	public static void main(String[] args) {

		LRUCache lruCache = new LRUCache();
		lruCache.putEntry(1, "One");
		lruCache.putEntry(2, "Two");
		lruCache.putEntry(2, "One");
		lruCache.display();
		lruCache.putEntry(3, "Three");
		lruCache.putEntry(4, "Four");
		lruCache.putEntry(3, "Three");	
		lruCache.display();
	}

}
class LRUCache{
	
	private Entry start;
	private static final int CAPACITY = 3;
	private Entry end;
	private Map<Integer, Entry> keyMap = new HashMap<Integer, Entry>(CAPACITY);
	static class Entry {
		Integer key;
		String value;
		Entry left;
		Entry right;
		public Entry(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	public void putEntry(Integer key, String value) {
		
		if(keyMap.containsKey(key)) {
			System.out.println(" Cacahe hit for "+key);
			Entry node = keyMap.get(key);
			node.value = value;
			removeNode(node);
			addToTop(node);			
		}else {
			if(keyMap.size() == CAPACITY) {				
				keyMap.remove(key);
				removeNode(end);			
			}
			System.out.println(" Cacahe miss for "+key);
			Entry newNode = new Entry(key, value);
			addToTop(newNode);			
			keyMap.put(key, newNode);			
		}
	}
	public String getEntry(Integer key) {
		Entry node = keyMap.get(key);
		if(node != null) {
			removeNode(node);
			addToTop(node);
			return node.value;	
		}else {
			return null;
		}			
	}
	public void display() {
		Entry node = start;
		while(node != null) {
			System.out.println(node.key);
			node = node.right;
		}
	}
	private void addToTop(Entry node) {	
		node.right = start;
		node.left = null;
		if(start != null) {
			start.left = node;
		}
		start = node;
		if(end == null) {
			end = start;
		}		
	}
	private void removeNode(Entry node) {
		Entry prev = node.left;
		Entry next = node.right;
		if(prev != null) {
			prev.right = next;			
		}else {
			// when it is top node
			start = next;
		}
		if(next != null) {
			next.left = prev;
		}else {
			// when it is end node
			end = prev;
		}
		
	}
	
	
}
