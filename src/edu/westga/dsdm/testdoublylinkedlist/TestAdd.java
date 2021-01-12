package edu.westga.dsdm.testdoublylinkedlist;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestAdd {

	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testAddEmpty() {
		this.list.add(0, 1);
		assertAll(() -> {
			assertEquals(1, this.list.getHead());
			assertEquals(1, this.list.getTail());
			assertEquals(1, this.list.size());
		});
	}
	
	@Test
	public void testAddWithOneInList() {
		this.list.addHead(1);
		this.list.add(1, 2);
		assertAll(() -> {
			assertEquals(1, this.list.get(0));
			assertEquals(1, this.list.getHead());
			assertEquals(2, this.list.get(1));
			assertEquals(2, this.list.getTail());
		});
	}
	
	@Test
	public void testAddWithMultipleInList() {
		this.list.addHead(1);
		this.list.addTail(3);
		this.list.add(1, 2);
		assertAll(() -> {
			assertEquals(3, this.list.size());
			assertEquals(1, this.list.get(0));
			assertEquals(2, this.list.get(1));
			assertEquals(3, this.list.get(2));
		});
	}

}
