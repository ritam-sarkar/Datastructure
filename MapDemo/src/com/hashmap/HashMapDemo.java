/**
 * 
 */
package com.hashmap;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author Ritam
 *
 */
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyMap<Integer,String> map = new MyMap<Integer,String>(10);
		map.put(1, "one");
		map.put(2, "two");
		System.out.println(map.get(1)+" "+map.get(2)+" "+map.size());
		
	}

}
class MyMap<K,V> {
	
	private Node<K,V>[] table;
	private int capacity;
	private int modcount;
	private static final int MAX_CAPACITY = 200;
	
	public MyMap(int capacity){
		if(capacity > 0){
			this.capacity = capacity;
		}else{
			this.capacity = MAX_CAPACITY;
		}
	}
	public MyMap(){
		this.capacity = MAX_CAPACITY;
	}
	public V put(K key,V value){
		return putVal(hash(key),key,value);
	}
	
	private V putVal(int hash, K key, V value) {
	 
		int i,n;		
		Node<K,V> newNode =  new Node<K,V>(value, key, hash, null);
		n = this.capacity -1;
		if(this.table == null){
			 this.table = (Node<K,V>[])new Node[this.capacity];
			 this.table[i = (n & hash)] = newNode;
			 this.modcount++;
		} else if(this.table[i = (n & hash)] == null){
			this.table[i = (n & hash)] = newNode;
			this.modcount++;
		} else if(this.table[i = (n & hash)] != null){
			Node<K,V> oldNode = this.table[i];
			while(oldNode.next != null){
				if(oldNode.getKey().equals(key)){
					return newNode.getValue();
				} else {
					oldNode = oldNode.next;
				}
			}
		    oldNode.next = newNode;
			this.modcount++;
		}
		 
		return null;
	}
	public V get(Object key){
		int hash = hash(key);
		int n = this.capacity-1;
		int i=0;
		if(this.table != null){
			i= n & hash;
			Node<K,V> node = this.table[i];
			if(node == null){
				return null;
			}else if(node.getHash() == hash){
				while(node != null && !node.getKey().equals(key)){
					node = node.next;
				}
				if(node != null && node.getKey() != null && node.getKey().equals(key)){
					return node.getValue();
				}
			}
			
		}
		return null;
	}
	 

	static final int hash(Object key) {
	        int h;
	        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	        return 11;
	 }

	class Node<K,V> implements Map.Entry<K, V>{		
		private Node<K,V> next;
		private V value;
		private K key;
		private int hash;
		
		
		public Node(V value, K key, int hash,Node<K, V> next) {
			super();
			this.next = next;
			this.value = value;
			this.key = key;
			this.hash = hash;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V newValue) {
			V oldValue = this.value;
			this.value = newValue;			
			return oldValue;
		}

		public int getHash() {
			return hash;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}
		
	}
	public int size(){
		return this.modcount;
	}
	
	
	
}
