/**
 * 
 */
package com.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Ritam
 *
 */

public class MyStackDemo{
	public static void main(String[] args){
		MyStack<Integer> stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.capacity());
	}
}
class MyStack<T> {

	private Object[] elementData;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	int modCount;
	int elementCount;
	int capacityIncrement;
	
	/**
	 * Constructors
	 
	 */
	public MyStack(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }
	public MyStack(){
		this(2);
	}
	public  MyStack(int initialCapacity) {
		this(initialCapacity,0);		
	}
	 
	/**
	 * Methods
	 */
	public  void ensureCapacity(int minCapacity) {
        if (minCapacity > 0) {
            modCount++;
            ensureCapacityHelper(minCapacity);
        }
    }
	private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
	private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
    public  int capacity() {
        return elementData.length;
    }
    public synchronized int size() {
        return elementCount;
    }
    public  boolean isEmpty() {
        return elementCount == 0;
    }
    
    public T push(T item){
    	addElement(item);
    	return item;
    }
	private void addElement(T item) {
		 modCount++;
	     ensureCapacityHelper(elementCount + 1);
	     elementData[elementCount++] = item;	
	}
	public T pop(){
		 T obj = null; 
		 int     len = size();
	     if (len == 0)
	       throw new EmptyStackException();
	     obj =  elementAt(len - 1);
	     removeElementAt(len-1);
	     return obj;
	     
	}
	private  T elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return (T) elementData[index];
    }
	private synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }
}
