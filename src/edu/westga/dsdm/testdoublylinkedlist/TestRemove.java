package edu.westga.dsdm.testdoublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.dsdm.model.DoublyLinkedList;

class TestRemove {

	private DoublyLinkedList<Integer> list;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.list = new DoublyLinkedList<Integer>();
	}

	@Test
	public void testRemoveEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.list.remove(0);
		});
	}
	
	@Test
	public void testRemoveOneFromOne() {
		this.list.add(0, 1);
		Integer value = this.list.remove(0);
		assertAll(()-> {
			assertEquals(1, value);
			assertEquals(0, this.list.size());
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getHead();
			});
		});
	}
	
	@Test
	public void testRemoveFirstOneFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value = this.list.remove(0);
		assertAll(()-> {
			assertEquals(1, value);
			assertEquals(2, this.list.size());
			assertEquals(2, this.list.getHead());
		});
	}
	
	@Test
	public void testRemoveMiddleOneFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value = this.list.remove(1);
		assertAll(()-> {
			assertEquals(2, value);
			assertEquals(2, this.list.size());
			assertEquals(1, this.list.getHead());
		});
	}
	
	@Test
	public void testRemoveLastOneFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value = this.list.remove(2);
		assertAll(()-> {
			assertEquals(3, value);
			assertEquals(2, this.list.size());
			assertEquals(1, this.list.getHead());
			assertEquals(2, this.list.getTail());
		});
	}
	
	@Test
	public void testRemoveAllFromMultiple() {
		this.list.add(0, 1);
		this.list.add(1, 2);
		this.list.add(2, 3);
		Integer value1 = this.list.remove(0);
		Integer value2 = this.list.remove(0);
		Integer value3 = this.list.remove(0);
		
		assertAll(()-> {
			assertEquals(3, value3);
			assertEquals(2, value2);
			assertEquals(1, value1);
			assertTrue(this.list.isEmpty());
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getHead();
			});
			assertThrows(NoSuchElementException.class, () -> {
				this.list.getTail();
			});
		});
	}

}
