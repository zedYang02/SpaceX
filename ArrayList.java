package lists;


import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;

public class ArrayList<E> implements List<E>{

	private int size;
	private E[] data;
	public static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayList(List<E> other) {

		this(DEFAULT_CAPACITY);
		size = other.size();
		for(int i=0;i<other.size();i++) {
			data[i] = other.get(i);
		}
	}
	
	public boolean add(E item) {
		
		int oldSize = size;
		ensureCapacity(size+1);
		data[size++] = item;
		
		return size == oldSize+1;
	}
	
	public void add(int index, E item) {
		
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException(index);
		ensureCapacity(size+1);
		shiftRight(index);
		data[index] = item;
		size++;
	}
	
	public void clear() {
		for(int i=0;i<size;i++) {
			data[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(E value) {
		return indexOf(value) != -1;
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		if(minCapacity > data.length) {
			int newLength = Math.max(2*data.length+1, minCapacity);
			E[] newArray = (E[]) new Object[newLength];
			
			for(int i=0;i<size;i++) {
				newArray[i] = data[i];
			}
			data = newArray;
		}
	}
	
	public boolean equals(List<E> other) {
		if(size!=other.size())
			return false;
		else {
			for(int i = 0;i<size;i++) {
				if(!data[i].equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
	}
	
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	public int indexOf(E item) {
		for(int i=0;i<size;i++) {
			if(data[i].equals(item))
				return i;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	
	public E remove(int index) {
		checkIndex(index);
		E value = data[index];
		shiftLeft(index);
		data[size--] = null;
		
		return value;
	}
	
	public boolean remove(E item) {
		if(contains(item) == false)
			return false;
		shiftLeft(indexOf(item));
		size--;
		data[size] = null;
		return true;
	}
	
	public E set(int index,E item) {
		checkIndex(index);
		E value = data[index];
		data[index] = item;
		return value;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(size==0)
			return "[]";
		else {
			StringBuilder result;
			result = new StringBuilder("["+data[0]);
			for(int i=1;i<size;i++) {
				result.append(", ").append(data[i]);
				
			}
			result.append("]");
			return result.toString();
		}
	}
	
	private void checkIndex(int index) {
		if(index<0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
	}
	
	private void shiftLeft(int index) {
		for(int i=index; i<size;i++) {
			data[i] = data[i+1];
		}
	}
	
	private void shiftRight(int index) {
		for(int i = size; i>index;i--) {
			data[i] = data[i-1];
		}
	}
	
	public class ArrayIterator implements Iterator<E>{
		
		private int position;
		private boolean isRemoveable;
		
		public ArrayIterator() {
			position = 0;
			isRemoveable = false;
		}
		
		public boolean hasNext() {
			return position < size;
		}
		
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException("No items left");
			position++;
			isRemoveable = true;
			return get(position-1);
		}
		
		public void remove() {
			if(!isRemoveable) 
				throw new IllegalStateException("Unable to remove item");
			ArrayList.this.remove(--position);
			isRemoveable = false;
		}
		
	}

	
}
