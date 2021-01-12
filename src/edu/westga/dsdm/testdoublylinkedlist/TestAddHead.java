package edu.westga.dsdm.testdoublylinkedlist;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

public class TestAddHead {
	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testAddEmpty() {
		this.list.addHead(1);
		assertAll(() -> {
			assertEquals(1, this.list.getHead());
			assertEquals(1, this.list.getTail());
			assertEquals(1, this.list.size());
		});
	}
	
	@Test
	public void testAddWithOneInList() {
		this.list.addHead(1);
		this.list.addHead(2);
		assertAll(() -> {
			assertEquals(2, this.list.getHead());
			assertEquals(1, this.list.getTail());
			assertEquals(2, this.list.size());
		});
	}
	
	@Test
	public void testAddWithMultipleInList() {
		this.list.addHead(1);
		this.list.addHead(2);
		this.list.addHead(3);
		
		assertAll(() -> {
			assertEquals(3, this.list.getHead());
			
			assertEquals(3, this.list.get(0));
			assertEquals(2, this.list.get(1));
			assertEquals(1, this.list.get(2));
			
			assertEquals(1, this.list.getTail());
			assertEquals(3, this.list.size());
		});
	}
}
