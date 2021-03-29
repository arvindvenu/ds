package com.arvind.ds.singlylinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.arvind.ds.singlylinkedlist.SinglyLinkedList;
import com.arvind.ds.singlylinkedlist.Node;

@RunWith(JUnit4.class)
public class SinglyLinkedListTest {
	SinglyLinkedList list = new SinglyLinkedList();
	
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
	public void test_InsertElementSomewhereInBetween() {
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
	public void test_InsertElementAtTheBeginning() {
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
	
	@Test
	public void test_InsertElementAtTheLast() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.insert(2,n3);
		assertEquals( n1, list.getHead());
		assertEquals(3,list.size());
		assertEquals(n1, list.get(0));
		assertEquals(n2, list.get(1));
		assertEquals(n3, list.get(2));	
	}
	
	@Test
	public void test_DeleteSomeNodeInBetween() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		list.delete(1);
		assertEquals(2, list.size());
		assertEquals(n1, list.getHead());
		assertEquals(n3, n1.getNext());
		assertNull(n2.getNext());
	}
	
	@Test
	public void test_DeleteLastNode() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		list.delete(2);
		assertEquals(2, list.size());
		assertEquals(n1, list.getHead());
		assertEquals(n2, n1.getNext());
		assertNull(n2.getNext());
	}
	
	@Test
	public void test_DeleteHeadNode() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		list.delete(0);
		assertEquals(2, list.size());
		assertEquals(n2, list.getHead());
		assertNull(n1.getNext());
	}
	
	@Test
	public void test_Reverse() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		list.reverse();
		assertEquals(n3, list.getHead());
		assertEquals(n2, list.get(1));
		assertEquals(n1, list.get(2));
	}
	
	@Test
	public void test_ReverseRecursive() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		list.reverseRecursive();
		assertEquals(n3, list.getHead());
		assertEquals(n2, list.get(1));
		assertEquals(n1, list.get(2));
	}
	
	@Test
	public void test_ReverseRecursive_4Nodes() {
		Node n1 = new Node();
		list.add(n1);
		Node n2 = new Node();
		list.add(n2);
		Node n3 = new Node();
		list.add(n3);
		Node n4 = new Node();
		list.add(n4);
		list.reverseRecursive();
		assertEquals(n4, list.getHead());
		assertEquals(n3, list.get(1));
		assertEquals(n2, list.get(2));
		assertEquals(n1, list.get(3));
	}

}
