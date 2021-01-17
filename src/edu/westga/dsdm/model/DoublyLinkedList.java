package edu.westga.dsdm.model;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoublyLinkedList<E> implements LinkedListOperations<E> {

	private Node head;
	private Node sentinal;
	private int size;
	
	/**
	 * Creates a new doubly-linked list
	 * 
	 * @Pre none
	 * @post size() == 0
	 */
	public DoublyLinkedList() {
		this.head = new Node(null);
		this.sentinal = new Node(null);
		this.size = 0;
	}
	
	/**
	 * Gets the forward iterator
	 * 
	 * @Pre None
	 * @Post none
	 */
	@Override
	public Iterator<E> iterator() {
		return this.getForwardIterator();
	}

	/**
	 * Adds the specified element at the tail end of the list
	 * 
	 * @Pre none
	 * @post size() == size()@Pre + 1 && getTail().equals(element)
	 * @param element the element to be added
	 */
	@Override
	public void addTail(E element) {
		Node newNode = new Node(element);
		
		
		if (this.head.next == null) {
			this.addHead(element);
			return;
		}
		this.size++;
		
		Node currentNode = this.head.next;
		while (currentNode.next != this.sentinal) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
		newNode.next = this.sentinal;
		newNode.prev = currentNode;
		this.sentinal.prev = newNode;
	}

	
	/**
	 * Adds to the beginning of the list
	 * 
	 * @Pre none
	 * @Post size() == size()@Pre + 1 && getHead() == element;
	 */
	@Override
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		if (this.head.next == null) {
			this.head.next = newNode;
			newNode.prev = this.head;
			newNode.next = this.sentinal;
			this.sentinal.prev = newNode;
			return;
		}
		
		newNode.next = this.head.next;
		this.head.next = newNode;
		newNode.prev = this.head;
	}


	/**
	 * Adds to any position of the list
	 * 
	 * @Pre index >= 0  && index <= size()
	 * @Post size() == size()@Pre + 1 && get(index) == element;
	 * @throws IndexOutOfBoundsException if the index is less than 0 or index is greater than size
	 */
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		if (index == 0) {
			this.addHead(element);
			return;
		}
		
		if (index == this.size) {
			this.addTail(element);
			return;
		}
		
		Node newNode = new Node(element);
		this.size++;
		
		Node currentNode = this.head.next;
		while (index > 1) {
			currentNode = currentNode.next;
			index--;
		}
		
		newNode.next = currentNode.next;
		newNode.prev = currentNode;
		
		currentNode.next.prev = newNode;
		currentNode.next = newNode;
	}
	
	/**
	 * Removes the last item in the list
	 * 
	 * @Pre none
	 * @Post size() == size()@Pre - 1;
	 * @return the element removed
	 * @throws NoSuchElementException if this list is empty
	 */
	@Override
	public E removeTail() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Node tailNode = this.sentinal.prev;
		this.sentinal.prev = tailNode.prev;
		tailNode.prev.next = tailNode.prev;
		this.size--;
		
		return tailNode.value;
	}

	/**
	 * Removes the first item in the list
	 * 
	 * @Pre none
	 * @Post size() == size()@Pre - 1;
	 * @return the element removed
	 * @throws NoSuchElementException if this list is empty
	 */
	@Override
	public E removeHead() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		Node nodeToRemove = this.head.next;
		this.head.next = nodeToRemove.next;
		nodeToRemove.next.prev = nodeToRemove.next;
		this.size--;
		
		return nodeToRemove.value;
	}

	/**
	 * Removes the item at the index given
	 * 
	 * @Pre index >= 0 && index < size()
	 * @Post size() == size()@Pre - 1;
	 * @return the element removed
	 * @throws IndexOutOfBoundsException if index less than 0 or index is greater than or equal to size
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		if (index == 0) {
			E value = this.removeHead();
			return value;
		}
		
		if (index == (this.size - 1)) {
			E value = this.removeTail();
			return value;
		}
		
		Node node = this.head.next;
		while (index > 0) {
			node = node.next;
			index--;
		}
		
		Node nextNode = node.next;
		Node prevNode = node.prev;
		
		nextNode.prev = prevNode;
		prevNode.next = nextNode;
		this.size--;
		
		return node.value;
	}

	/**
	 * Gets the end element in the list
	 * @Pre none
	 * @Post none
	 * @return the element at the end of the list
	 * @throws NoSuchElementException if this list is empty
	 */
	@Override
	public E getTail() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.sentinal.prev.value;
	}

	/**
	 * Gets the start element in the list
	 * @Pre none
	 * @Post none
	 * @return the element at the start of the list
	 * @throws NoSuchElementException if this list is empty
	 */
	@Override
	public E getHead() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return this.head.next.value;
	}

	/**
	 * Gets the element at the index
	 * @Pre index >= 0 && index < size
	 * @Post none
	 * @return the element at the index of the list
	 * @throws IndexOutOfBoundsException if index less than 0 or index is greater than or equal to size
	 * 
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		Node node = this.head.next;
		while (index > 0) {
			node = node.next;
			index--;
		}
		
		return node.value;
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return the size of the list
	 * @throws IndexOutOfBoundsException if index less than 0 or index is greater than or equal to size
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Determines if the list is empty
	 * 
	 * @return true if the list size is 0 false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * The iterator for traversing the list forwards
	 * @return the forward iterator
	 */
	@Override
	public Iterator<E> getForwardIterator() {
		return new ForwardIterator();
	}

	/**
	 * The iterator for traversing the list backwards
	 * @return the backward iterator
	 */
	@Override
	public Iterator<E> getBackwardIterator() {
		return new BackwardIterator();
	}
	
	private String outOfBoundsMessage(int index) {
		return "Index " + index + " out of bounds for list of size " + this.size;
	}
	
	private final class ForwardIterator implements Iterator<E> {
		
		private Node nextNode;
		
		private ForwardIterator() {
			this.nextNode = DoublyLinkedList.this.head.next;
		}
		
		@Override
		public boolean hasNext() {
			return this.nextNode != DoublyLinkedList.this.sentinal && this.nextNode != null;
		}

		@Override
		public E next() {
			E value = this.nextNode.value;
			this.nextNode = this.nextNode.next;
			return value;
		}
	}
	
	private final class BackwardIterator implements Iterator<E> {
		
		private Node prevNode;
		
		private BackwardIterator() {
			this.prevNode = DoublyLinkedList.this.sentinal.prev;
		}
		
		@Override
		public boolean hasNext() {
			return this.prevNode != DoublyLinkedList.this.head && this.prevNode != null;
		}

		@Override
		public E next() {
			E value = this.prevNode.value;
			this.prevNode = this.prevNode.prev;
			return value;
		}
	}
	
	private final class Node {
		private E value;
		private Node prev;
		private Node next;
		
		private Node(E item) {
			this.value = item;
			this.prev = null;
			this.next = null;
		}
	}

}
