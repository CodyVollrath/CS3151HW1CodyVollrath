package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The Class SinglyLinkedList
 * 
 * @author CS3151
 * @param <E> type of list elements
 */
public class SinglyLinkedList<E> implements LinkedListOperations<E> {

	private Node head;
	private int size;

	/**
	 * Creates a new singly-linked list
	 * 
	 * @pre none
	 * @post size() == 0
	 */
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Adds the specified element at the tail of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getTail().equals(element)
	 * @param element the element to be added
	 */
	public void addTail(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		if (this.head == null) {
			this.head = newNode;
			return;
		}

		Node node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	/**
	 * Adds the specified element at the head of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getHead().equals(element)
	 * @param element the element to be added
	 */
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		newNode.next = this.head;
		this.head = newNode;
	}

	/**
	 * Adds the element at the specified index in this list. Shifts existing
	 * elements at the specified and greater indices to the right.
	 * 
	 * @pre 0 <= index <= size()
	 * @post size() == size()@pre + 1 && get(index).equals(element)
	 * @param index   the index at which the element is to be inserted
	 * @param element the element to be inserted
	 * @throws IndexOutOfBoundsException if index < 0 or index > size()
	 */
	public void add(int index, E element) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		if (index == 0) {
			this.addHead(element);
			return;
		}
		
		Node newNode = new Node(element);
		this.size++;
		Node node = this.head;
		while (index > 1) {
			node = node.next;
			index--;
		}
		newNode.next = node.next;
		node.next = newNode;
	}

	/**
	 * removes the element at the tail of this list
	 * 
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		
		if (this.size == 1) {
			return this.removeHead();
		}
		
		this.size--;
		Node node = this.head;
		while (node.next.next != null) {
			node = node.next;
		}
		E value = node.next.value;
		node.next = null;
		return value;
	}

	/**
	 * Removes the element at the head of this list
	 *
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeHead() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		
		this.size--;
		E value = this.head.value;
		this.head = this.head.next;
		return value;
	}

	/**
	 * Removes the element at the specified index. Shifts subsequent elements to the
	 * left.
	 * 
	 * @pre 0 <= index < size
	 * @post size() == size()@pre - 1
	 * @param index the index of the element to be removed
	 * @return the removed element
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public E remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		if (index == 0) {
			return this.removeHead();
		}
		if (index == this.size - 1) {
			return this.removeTail();
		}
		
		this.size--;
		Node node = this.head;
		while (index > 1) {
			node = node.next;
			index--;
		}
		E value = node.next.value;
		node.next = node.next.next;
		return value;
	}

	/**
	 * Gets the element at the tail of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the tail of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getTail() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		return this.get(this.size - 1);
	}

	/**
	 * Gets the element at the head of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the head of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public E getHead() {
		if (this.size <= 0) {
			throw new NoSuchElementException();
		}
		return this.head.value;
	}

	/**
	 * Gets the element at the specified index.
	 * 
	 * @pre 0 <= index < size
	 * @post none
	 * @param index the index of the element to be returned
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		Node node = this.head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		return node.value;
	}

	/**
	 * Gets the size.
	 * 
	 * @pre none
	 * @post none
	 * @return the number if elements in this list
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Check if this list is empty.
	 * 
	 * @pre none
	 * @post none
	 * @return true if this list is empty
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public Iterator<E> getForwardIterator() {
		return new ForwardIterator();
	}

	@Override
	public Iterator<E> getBackwardIterator() {
		return new BackwardIterator();
	}
	
	private String outOfBoundsMessage(int index) {
		return "Index " + index + " out of bounds for list of size " + this.size;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}

	private final class Node {
		private E value;
		private Node next;

		private Node(E item) {
			this.value = item;
			this.next = null;
		}
	}

	/**
	 * Class ForwardIterator
	 * 
	 * @author CS3151
	 */
	public class ForwardIterator implements Iterator<E> {
		private Node nextNode;

		/**
		 * Instantiates a new forward iterator
		 */
		public ForwardIterator() {
			this.nextNode = SinglyLinkedList.this.head;
		}

		@Override
		public boolean hasNext() {
			return this.nextNode != null;
		}

		@Override
		public E next() {
			E element = this.nextNode.value;
			this.nextNode = this.nextNode.next;
			return element;
		}
	}
	
	/**
	 * Class ForwardIterator
	 * 
	 * @author CS3151
	 */
	public class BackwardIterator implements Iterator<E> {
		private int nextIndex;

		/**
		 * Instantiates a new forward iterator
		 */
		public BackwardIterator() {
			this.nextIndex = SinglyLinkedList.this.size - 1;
		}

		@Override
		public boolean hasNext() {
			return this.nextIndex >= 0;
		}

		@Override
		public E next() {
			E element = SinglyLinkedList.this.get(this.nextIndex);
			this.nextIndex--;
			return element;
		}
	}
}
