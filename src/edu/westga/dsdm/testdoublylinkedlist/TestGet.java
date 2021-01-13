package edu.westga.dsdm.testdoublylinkedlist;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

public class TestGet {

	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testGetFromEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.list.get(0);
		});
	}
	
	@Test
	public void testGetFromSingleItemList() {
		this.list.add(0, 1);
		assertEquals(1, this.list.get(0));
	}
	
	@Test
	public void testGetFromMultiItemList() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		assertEquals(2, this.list.get(1));
	}

}
