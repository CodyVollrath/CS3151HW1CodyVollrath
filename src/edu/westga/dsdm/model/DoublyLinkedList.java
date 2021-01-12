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
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
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
		
		
		if (this.head.nextNode == null) {
			this.addHead(element);
			return;
		}
		this.size++;
		
		Node currentNode = this.head.nextNode;
		while (currentNode.nextNode != this.sentinal) {
			currentNode = currentNode.nextNode;
		}
		
		currentNode.nextNode = newNode;
		newNode.nextNode = this.sentinal;
		newNode.prevNode = currentNode;
		this.sentinal.prevNode = newNode;
	}

	
	@Override
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		if (this.head.nextNode == null) {
			this.head.nextNode = newNode;
			newNode.prevNode = this.head;
			newNode.nextNode = this.sentinal;
			this.sentinal.prevNode = newNode;
			return;
		}
		
		newNode.nextNode = this.head.nextNode;
		this.head.nextNode = newNode;
		newNode.prevNode = this.head;
	}

	//TODO Does not work, sential value never gets updated
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
		
		Node currentNode = this.head.nextNode;
		while (index > 1) {
			currentNode = currentNode.nextNode;
			index--;
		}
		
		newNode.nextNode = currentNode.nextNode;
		newNode.prevNode = currentNode;
		
		currentNode.nextNode.prevNode = newNode;
		currentNode.nextNode = newNode;
	}

	@Override
	public E removeTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeHead() {
		if (this.head.nextNode == null) {
			return null;
		}
		Node nodeToRemove = this.head.nextNode;
		this.head.nextNode = nodeToRemove.nextNode;
		this.size--;
		
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getTail() {
		return this.sentinal.prevNode.value;
	}

	@Override
	public E getHead() {
		
		return this.head.nextNode.value;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMessage(index));
		}
		
		Node node = this.head.nextNode;
		while (index > 0) {
			node = node.nextNode;
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
	public Iterator getForwardIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getBackwardIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String outOfBoundsMessage(int index) {
		return "Index " + index + " out of bounds for list of size " + this.size;
	}
	
	private final class Node {
		private E value;
		private Node prevNode;
		private Node nextNode;
		
		private Node(E item) {
			this.value = item;
			this.prevNode = null;
			this.nextNode = null;
		}
	}

}
