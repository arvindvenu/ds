package com.arvind.ds.singlylinkedlist;

import java.util.Arrays;

public class SinglyLinkedList<T> {

	private int size = 0;
	private Node<T> head;

	public SinglyLinkedList() {

	}

	public SinglyLinkedList(T... entries) {
		Arrays.stream(entries).forEach(this::add);
	}

	public Node<T> getHead() {
		return head;
	}

	public int size() {
		return size;
	}

	public void add(T entry) {
		insert(size, entry);
	}

	public void insert(int i, T entry) {
		insert(i, new Node<T>(entry));
	}

	public T get(int i) {
		return getNodeAt(i).getData();
	}

	public void delete(int i) {
		if (i == 0) {
			Node<T> temp = head;
			head = head.getNext();
			temp.setNext(null);
		} else {
			Node<T> nodeBeforeIthNode = getNodeAt(i - 1);
			Node<T> ithNode = nodeBeforeIthNode.getNext();
			nodeBeforeIthNode.setNext(ithNode.getNext());
			ithNode.setNext(null);
		}
		size--;
	}

	public void reverse() {
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void reverseRecursive() {
		reverseRecursive(head);
	}

	private void insert(int i, Node<T> n) {
		if (i == 0) {
			n.setNext(head);
			head = n;
		} else {
			Node<T> nodeBeforeIthNode = getNodeAt(i - 1);
			Node<T> ithNode = nodeBeforeIthNode.getNext();
			n.setNext(ithNode);
			nodeBeforeIthNode.setNext(n);
		}
		size++;
	}

	private Node<T> getNodeAt(int i) {
		int currPos = 0;
		Node<T> currentNode = head;

		while (currPos < i) {
			currentNode = currentNode.getNext();
			currPos++;
		}
		return currentNode;
	}

	private void reverseRecursive(Node<T> current) {
		if (current.getNext() == null) {
			head = current;
			return;
		}
		Node<T> next = current.getNext();
		reverseRecursive(next);
		next.setNext(current);
		current.setNext(null);
	}

}
