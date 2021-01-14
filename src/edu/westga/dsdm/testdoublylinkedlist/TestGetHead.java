package edu.westga.dsdm.testdoublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestGetHead {

	private DoublyLinkedList<Integer> list;
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testGetEmptyHead() {
		assertEquals(null, this.list.getHead());
	}
	
	@Test
	public void testGetSingleHead() {
		this.list.add(0, 1);
		assertEquals(1, this.list.getHead());
	}
	
	@Test
	public void testGetMultiItemHead() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		assertEquals(1, this.list.getHead());
	}

}
