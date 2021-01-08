package edu.westga.dsdm.model;

import java.util.Iterator;

/**
 * The Interface DSDMLinkedList
 * 
 * @author CS3151
 * @param <E> type of list elements
 */
public interface LinkedListOperations<E> extends Iterable<E> {
	/**
	 * Adds the specified element at the tail of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getTail().equals(element)
	 * @param element the element to be added
	 */
	void addTail(E element);

	/**
	 * Adds the specified element at the head of this list
	 * 
	 * @pre none
	 * @post size() == size()@pre + 1 && getHead().equals(element)
	 * @param element the element to be added
	 */
	void addHead(E element);

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
	void add(int index, E element);

	/**
	 * removes the element at the tail of this list
	 * 
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	E removeTail();

	/**
	 * Removes the element at the head of this list
	 *
	 * @pre size() > 0
	 * @post size() == size()@pre - 1
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	E removeHead();

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
	E remove(int index);

	/**
	 * Gets the element at the tail of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the tail of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	E getTail();

	/**
	 * Gets the element at the head of this list
	 * 
	 * @pre none
	 * @post none
	 * @return the element at the head of this list
	 * @throws NoSuchElementException if this list is empty
	 */
	E getHead();

	/**
	 * Gets the element at the specified index.
	 * 
	 * @pre 0 <= index < size
	 * @post none
	 * @param index the index of the element to be returned
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	E get(int index);

	/**
	 * Gets the size.
	 * 
	 * @pre none
	 * @post none
	 * @return the number if elements in this list
	 */
	int size();

	/**
	 * Check if this list is empty.
	 * 
	 * @pre none
	 * @post none
	 * @return true if this list is empty
	 */
	boolean isEmpty();

	/**
	 * Gets an iterator to traverse the list from head to tail
	 * 
	 * @return an iterator that traverses this list from head to tail
	 */
	Iterator<E> getForwardIterator(); 
	
	/**
	 * Gets an iterator to traverse the list from tail to head
	 * 
	 * @return an iterator that traverses this list from tail to head
	 */
	Iterator<E> getBackwardIterator();
}
