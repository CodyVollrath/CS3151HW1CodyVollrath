package edu.westga.dsdm.model;

import java.util.Iterator;


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

	@Override
	public E removeTail() {
		if (this.head.next == null) {
			return null;
		}
		
		Node tailNode = this.sentinal.prev;
		this.sentinal.prev = tailNode.prev;
		tailNode.prev.next = tailNode.prev;
		this.size--;
		
		return tailNode.value;
	}

	@Override
	public E removeHead() {
		if (this.head.next == null) {
			return null;
		}
		Node nodeToRemove = this.head.next;
		this.head.next = nodeToRemove.next;
		nodeToRemove.next.prev = nodeToRemove.next;
		this.size--;
		
		return nodeToRemove.value;
	}

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

	@Override
	public E getTail() {
		if (this.sentinal.prev == null) {
			return null;
		}
		return this.sentinal.prev.value;
	}

	@Override
	public E getHead() {
		if (this.head.next == null) {
			return null;
		}
		
		return this.head.next.value;
	}

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

	@Override
	public int size() {
		return this.size;
	}

	@Override
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
