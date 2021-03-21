package com.arvind.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListTest {
	LinkedList list = new LinkedList();
	
	@Test
	public void test_EmptyLinkedList() {
		assertNull(list.getHead());
		assertEquals(0, list.size());
	}
	
	@Test
	public void test_AddSingleNodeToList() {
		Node n = new Node();
		list.add(n);
		assertEquals( n, list.getHead());
		assertEquals(1,list.size());
		assertNull(list.getHead().getNext());
		assertEquals(n, list.get(0));
	}
	
	@Test
	public void test_AddTwoNodesToList() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		assertEquals( n1, list.getHead());
		assertEquals(n2, n1.getNext());
		assertEquals(2,list.size());
		assertEquals(n1, list.get(0));
		assertEquals(n2, list.get(1));
	}
	
	@Test
	public void test_AddTwoNodesToListAndInsertThirdElementInBetween() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.insert(1,n3);
		assertEquals( n1, list.getHead());
		assertEquals(n3, n1.getNext());
		assertEquals(3,list.size());
		assertEquals(n1, list.get(0));
		assertEquals(n3, list.get(1));
		assertEquals(n2, list.get(2));
	}
	
	@Test
	public void test_AddTwoNodesToListAndInsertThirdElementAtTheBeginning() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.insert(0,n3);
		assertEquals( n3, list.getHead());
		assertEquals(n1, n3.getNext());
		assertEquals(3,list.size());
		assertEquals(n3, list.get(0));
		assertEquals(n1, list.get(1));
		assertEquals(n2, list.get(2));
	}

}
