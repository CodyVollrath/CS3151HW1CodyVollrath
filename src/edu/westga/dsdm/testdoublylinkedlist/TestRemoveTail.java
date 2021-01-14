package edu.westga.dsdm.testdoublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestRemoveTail {

	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testRemoveEmpty() {
		Integer value = this.list.removeTail();
		assertEquals(null, value);
	}
	
	@Test
	public void testRemoveOneFromOne() {
		this.list.add(0, 1);
		Integer value = this.list.removeTail();
		assertAll(()-> {
			assertEquals(1, value);
			assertEquals(0, this.list.size());
			assertEquals(null, this.list.getTail());
		});
	}
	
	@Test
	public void testRemoveOneFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value = this.list.removeTail();
		assertAll(()-> {
			assertEquals(3, value);
			assertEquals(2, this.list.size());
			assertEquals(2, this.list.getTail());
		});
	}
	
	@Test
	public void testRemoveAll() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value1 = this.list.removeTail();
		Integer value2 = this.list.removeTail();
		Integer value3 = this.list.removeTail();
		assertAll(()-> {
			assertEquals(3, value1);
			assertEquals(2, value2);
			assertEquals(1, value3);
			assertEquals(0, this.list.size());
			assertEquals(null, this.list.getTail());
			assertEquals(null, this.list.getHead());
			assertTrue(this.list.isEmpty());
		});
		
	}

}
