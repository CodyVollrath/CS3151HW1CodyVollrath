package edu.westga.dsdm.testdoublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestGetBackwardIterator {

	private DoublyLinkedList<Integer> list;
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testHasNextEmpty() {
		Iterator<Integer> iterable = this.list.getBackwardIterator();
		assertTrue(!iterable.hasNext());
	}
	
	@Test
	public void testHasNextSingle() {
		this.list.add(0, 1);
		Iterator<Integer> iterable = this.list.getBackwardIterator();
		
		assertAll(() -> {
			assertTrue(iterable.hasNext());
			assertEquals(1, iterable.next());
			assertTrue(!iterable.hasNext());
		});
	}
	
	@Test
	public void testHasNextMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Iterator<Integer> iterable = this.list.getBackwardIterator();
		
		assertAll(() -> {
			assertTrue(iterable.hasNext());
			assertEquals(3, iterable.next());
			assertTrue(iterable.hasNext());
			assertEquals(2, iterable.next());
			assertTrue(iterable.hasNext());
			assertEquals(1, iterable.next());
			assertTrue(!iterable.hasNext());
		});
	}

}
