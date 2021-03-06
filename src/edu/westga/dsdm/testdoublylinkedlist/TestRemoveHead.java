package edu.westga.dsdm.testdoublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestRemoveHead {

	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testRemoveEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			this.list.removeHead();
		});
	}
	
	@Test
	public void testRemoveOneFromOne() {
		this.list.add(0, 1);
		Integer value = this.list.removeHead();
		assertAll(()-> {
			assertEquals(1, value);
			assertEquals(0, this.list.size());
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getHead();
			});
		});
	}
	
	@Test
	public void testRemoveOneFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value = this.list.removeHead();
		assertAll(()-> {
			assertEquals(1, value);
			assertEquals(2, this.list.size());
			assertEquals(2, this.list.getHead());
			assertTrue(!this.list.isEmpty());
		});
	}
	
	@Test
	public void testRemoveAll() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		
		Integer value1 = this.list.removeHead();
		Integer value2 = this.list.removeHead();
		Integer value3 = this.list.removeHead();
		
		assertAll(()-> {
			assertEquals(1, value1);
			assertEquals(2, value2);
			assertEquals(3, value3);
			assertEquals(0, this.list.size());
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getHead();
			});
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getTail();
			});
			assertTrue(this.list.isEmpty());
		});
	}
}
