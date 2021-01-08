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
		this.size++;
		
		if (this.head.nextNode == null) {
			this.head.nextNode = newNode;
			this.sentinal.prevNode = newNode;
			return;
		}
		
		Node node = this.head.nextNode;
		while (node.nextNode != null) {
			node = node.nextNode;
		}
		node.nextNode = newNode;
		this.sentinal.prevNode = newNode;
	}

	@Override
	public void addHead(E element) {
		Node newNode = new Node(element);
		this.size++;
		
		newNode.nextNode = this.head.nextNode;
		this.head.nextNode = newNode;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeHead() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
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
