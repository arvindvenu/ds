package com.arvind.ds.singlylinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SinglyLinkedListTest {
	SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

	@Test
	public void test_EmptyLinkedList() {
		assertNull(list.getHead());
		assertEquals(0, list.size());
	}

	@Test
	public void test_AddSingleNodeToList() {
		Node<Integer> n = new Node<>(1);
		list.add(1);
		assertOrderAndSize(n);
	}

	@Test
	public void test_AddTwoNodesToList() {
		Node<Integer> n1 = new Node<>(1);
		list.add(1);
		Node<Integer> n2 = new Node<>(2);
		list.add(2);
		assertOrderAndSize(n1, n2);
	}

	@Test
	public void test_InsertElementSomewhereInBetween() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		list = new SinglyLinkedList<Integer>(1, 2);
		Node<Integer> n3 = new Node<>(3);
		list.insert(1, 3);
		assertOrderAndSize(n1, n3, n2);
	}

	@Test
	public void test_InsertElementAtTheBeginning() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		list = new SinglyLinkedList<Integer>(1, 2);
		Node<Integer> n3 = new Node<>(3);
		list.insert(0, 3);
		assertOrderAndSize(n3, n1, n2);
	}

	@Test
	public void test_InsertElementAtTheLast() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		list = new SinglyLinkedList<Integer>(1, 2);
		Node<Integer> n3 = new Node<>(3);
		list.insert(2, 3);
		assertOrderAndSize(n1, n2, n3);
	}

	@Test
	public void test_DeleteSomeNodeInBetween() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n3 = new Node<>(3);
		list = new SinglyLinkedList<Integer>(1, 2, 3);
		list.delete(1);
		assertOrderAndSize(n1, n3);
	}

	@Test
	public void test_DeleteLastNode() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		list = new SinglyLinkedList<Integer>(1, 2, 3);
		list.delete(2);
		assertOrderAndSize(n1, n2);
	}

	@Test
	public void test_DeleteHeadNode() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		list = new SinglyLinkedList<Integer>(1, 2, 3);
		list.delete(0);
		assertOrderAndSize(n2, n3);
	}

	@Test
	public void test_Reverse() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		list = new SinglyLinkedList<Integer>(1, 2, 3);
		list.reverse();
		assertOrderAndSize(n3, n2, n1);
	}

	@Test
	public void test_ReverseRecursive() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		list = new SinglyLinkedList<Integer>(1, 2, 3);
		list.reverseRecursive();
		assertOrderAndSize(n3, n2, n1);
	}

	@Test
	public void test_ReverseRecursive_4Nodes() {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		list = new SinglyLinkedList<Integer>(1, 2, 3, 4);
		list.reverseRecursive();
		assertOrderAndSize(n4, n3, n2, n1);
	}

	private void assertOrderAndSize(Node<Integer>... nodes) {
		assertEquals(list.getHead(), nodes[0]);
		IntStream.range(0, nodes.length).forEach(i -> assertEquals(nodes[i], new Node<Integer>(list.get(i))));
		assertEquals(nodes.length, list.size());
	}

}
