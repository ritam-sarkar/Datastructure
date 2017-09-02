/**
 * 
 */
package com.hashmap;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import com.hashmap.MyMap.Node;

/**
 * @author Ritam
 *
 */
public class ConcurrentHashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub     
		
		MyConCurrentHashMap<Integer,String> map = new MyConCurrentHashMap<Integer,String>(10);
		/*map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "one");*/
		
	     WorkThread th1 = new WorkThread(map, "Thread1", 2, 5,false);
	     WorkThread th2 = new WorkThread(map, "Thread2", 3, 8,false);
	     /*WorkThread th3 = new WorkThread(map, "Thread3", 2, 5,true);
	     WorkThread th4 = new WorkThread(map, "Thread4", 3, 8,true);*/
	     
	     th1.start();
	     th2.start();
	     /*th3.start();
	     th4.start();*/
	     System.out.println(map.get(2));
	    
		
		/*System.out.println(map.size());
		System.out.println(map.get(2));*/      
      
	}	
}
class WorkThread extends Thread{
	
	private MyConCurrentHashMap<Integer,String> map;
	private int from;
	private int to;
	private boolean isRead;
	public WorkThread(MyConCurrentHashMap<Integer,String> map,String name,int from,int to,boolean isRead){
		super(name);
		this.map = map;
		this.from = from;
		this.to = to;
		this.isRead = isRead;
	}
	@Override
	public void run(){		
		if(!isRead){
			for(int i = this.from;i<this.to;i++){
				this.map.put(i, "abc");			
			}
		}else{
			for(int i = this.from;i<this.to;i++){
				System.out.println(Thread.currentThread().getName()+" getting value "+this.map.get(i)+" for key "+i);
			
			}
		}
		
	}
}

class MyConCurrentHashMap<K,V> {
	
	private Segment<K,V>[] table = null;
	private int modcount;
	private int capacity;
	
	
	public MyConCurrentHashMap(int capacity) {
		super();
		this.capacity = capacity;
		this.table = new Segment[this.capacity];
		for(int i=0;i<this.capacity;i++){
			this.table[i] = new Segment();
		}
		this.modcount =0;
	}
	
	public void put(K key,V value){
		int hashval = key.hashCode();
		int hashIndex = hashIndex(hashval);
		if(this.table[hashIndex] != null){
			Segment<K,V> segment = this.table[hashIndex];
            if(segment.isLocked()){
				System.out.println(Thread.currentThread().getName()+" cannot get the lock for segement "+hashIndex);
			}
            
        	if(segment.tryLock()){
				System.out.println(Thread.currentThread().getName()+" putting data for key "+key+" at segment "+hashIndex);
				Node<K,V> node = segment.getNode();
				if(node == null){
					segment.setNode(new Node(value, key, hashval, null));
					segment.setHash(hashval);
				}else if(node != null){
					Node<K,V> x = node;
					while(x.next != null &&  !x.getKey().equals(key) && x.getHash() == hashval){
						x = x.next;
				    }
					if(x != null){
						x.next = new Node(value, key, hashval, null);
					}
				}
				segment.setHash(hashval);				
				this.modcount++;
				segment.unlock();
				
			}
            			
		}
		
	}
	public V get(K key){
		int hashVal = key.hashCode();
		int hashIndex = hashIndex(hashVal);
		V value = null;
		if(this.table[hashIndex] != null){
			System.out.println(Thread.currentThread().getName()+" getting data for key "+key+" at segment"+hashIndex);
			Segment<K,V> seg = this.table[hashIndex];
			if(seg.getHash() == hashVal){
				Node<K,V> node = seg.getNode();
				if(node != null && node.next != null && !node.getKey().equals(key)){
					node = node.next;
				}
				if(node.getKey().equals(key)){
					value = node.getValue();
				}				
			}
		    return value;	
		}else{
			return null;
		}
	}
	public int size(){
		return this.modcount;
	}
	
	public Set<K> keySet(){
		
	}
	private int hashIndex(int hash){
		return hash & (this.capacity-1);
	}
	class Segment<K,V> extends ReentrantLock{
		private int hash;
		private Node<K,V> node;	
		
		public Segment() {
			super();
		}


		public Node<K, V> getNode() {
			return node;
		}

		public void setNode(Node<K, V> node) {
			this.node = node;
		}

		public int getHash() {
			return hash;
		}


		public void setHash(int hash) {
			this.hash = hash;
		}
		
		
		
		
	}
	class Node<K,V>{
		
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

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

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

}

