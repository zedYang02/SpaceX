package lists;

import java.util.NoSuchElementException;

import utility.Iterator;
import utility.List;

public class LinkedList<E> implements List<E> {

	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	
	public LinkedList(List<E> other) {
		
		size = other.size();
		first = new Node<E>(null,other.get(0));
		Node<E> current = first;
		for(int i = 1;i<size;i++) {
			current.next = new Node<E>(current,other.get(i));
			current = current.next;
		}
		last = current;
	}
	
	public boolean add(E item) {
		int oldSize = size;
		Node<E> oldLast = last;
		Node<E> newNode = new Node<E>(oldLast,item);
		last = newNode;
		if(oldLast == null) {
			first = newNode;
		}else {
			oldLast.next = newNode;
		}
		size++;
		return size == oldSize+1;
	}
	
	public void add(int index, E item) {
		
		if(index == 0) {
			first = new Node<E>(null,first,item);
		}else {
			insertBefore(index,item);
		}
		size++;
	}

	public void clear() {
		
		while(size>0) {
			set(size-1,null);
			size--;
		}
	}
	
	public boolean contains(E item) {
		return indexOf(item) != -1;
	}
	
	public boolean equals(List<E> other) {
		if(size!=other.size())
			return false;
		for(int i = 0;i<size;i++) {
			if(!get(i).equals(other.get(i)))
				return false;
		}
		return true;
	}
	
	public int indexOf(E item) {
		int index = 0;
		Node<E> current = first;
		while(current!=null) {
			if(current.data.equals(item))
				return index;
			index++;
			current = current.next;
		}
		return -1;
	}
	
	public E get(int index) {
		checkIndex(index);
		return (E) node(index).data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E remove(int index) {
		checkIndex(index);
		return detach(index);
	}
	
	public boolean remove(E item) {
		if(contains(item) == false)
			return false;
		int index = indexOf(item);
		detach(index);
		return true;
	}
	
	public E set(int index,E item) {
		checkIndex(index);
		Node<E> current = node(index);
		E data = (E) current.data;
		current.data = item;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		if(size==0)
			return "[]";
		else {
			StringBuilder result;
			Node<E> current = first;
			result = new StringBuilder("["+current.data);
			while(current.next!=null) {
				current = current.next;
				result.append(", ").append(current.data);
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
	
	private E detach(int index) {
		
		Node<E> current = node(index);
		Node<E> prev = current.prev;
		Node<E> next = current.next;
		E item = (E) current.data;
		
		if(prev == null) {
			first = next;
		}else {
			prev.next = next;
			current.prev = null;
		}
		
		if(next == null) {
			last = prev;
		}else {
			next.prev = prev;
			current.next = null;
		}
		current.data = null;
		
		size--;
		return item;
	}
	
	private void insertBefore(int index,E item) {
		
		Node<E> current = first;
		for(int i=0;i<index-1;i++) {
			current = current.next;
		}
		Node<E> next = current.next;
		if(next!=null) {
			Node<E> newNode = new Node<E>(current,current.next,item);
			current.next = newNode;
			next.prev = newNode;
		}else {
			Node<E> newNode = new Node<E>(current,item);
			current.next = newNode;
			last = newNode;
		}

	}
	
	public Iterator<E> iterator(){
		return new LinkedIterator();
	}
	
	private Node<E> node(int index) {
		
		Node<E> current = null;
		if(index < size/2) {
			current = first;
			for(int i=0;i<index;i++) {
				current = current.next;
			}
		}else {
			current = last;
			for(int i = size-1;i>index;i--) {
				current = current.prev;
			}
		}
		
		return current;
	}
	
	public Node<E> swapPairs(Node<E> head) {
        if(head == null || head.next == null)
            return head;
        Node<E> newHead = head.next;
        Node<E> current = head;
        while(current.next != null){
            Node<E> n = current.next;
            current.next = current.next.next;
            n.next = current;
            current = current.next;
        }
        return newHead;
    }
	
	public class LinkedIterator implements Iterator<E>{
		
		private Node<E> current;
		private int position;
		private boolean isRemoveable;
		
		public LinkedIterator() {
			current = first;
			position = 0;
			isRemoveable = false;
		}
		
		public boolean hasNext() {
			return position < size;
		}
		
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException("No items left");
			E currentItem = current.data;
			current = current.next;
			position++;
			isRemoveable = true;
			return currentItem;
		}
		
		public void remove() {
			if(!isRemoveable) 
				throw new IllegalStateException("Unable to remove item");
			LinkedList.this.remove(--position);
			isRemoveable = false;
		}
	}
	
	public static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		private Node(Node<E> prev, E data) {
			this(prev,null,data);
		}
		
		private Node(Node<E> prev, Node<E> next, E data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
		
	}
}
