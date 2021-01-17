package edu.westga.dsdm.testdoublylinkedlist;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

public class TestGetTail {

	private DoublyLinkedList<Integer> list;
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testGetEmptyTail() {
		assertThrows(NoSuchElementException.class, () -> {
			this.list.getTail();
		});
	}
	
	@Test
	public void testGetSingleTail() {
		this.list.add(0, 1);
		assertEquals(1, this.list.getTail());
	}
	
	@Test
	public void testGetMultiItemTail() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		assertEquals(3, this.list.getTail());
	}

}
