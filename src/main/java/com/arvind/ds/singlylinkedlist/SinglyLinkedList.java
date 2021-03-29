package com.arvind.ds.singlylinkedlist;

public class SinglyLinkedList {
	private int size = 0;
	private Node head;

	public Node getHead() {
		return head;
	}

	public int size() {
		return size;
	}

	public void add(Node n) {
		insert(size, n);
	}
	
	public void insert(int i, Node n) {
		if(i == 0) {
			n.setNext(head);
			head = n;
		} else {
			Node nodeBeforeIthNode = get(i-1);
			Node ithNode = nodeBeforeIthNode.getNext();
			n.setNext(ithNode);
			nodeBeforeIthNode.setNext(n);
		}
		size++;
	}

	public Node get(int i) {
		int currPos = 0;
		Node currentNode = head;
		
		while(currPos < i) {
			currentNode = currentNode.getNext();
			currPos++;
		}
		return currentNode;
	}

	public void delete(int i) {
		if(i ==0 ) {
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
		} else {
			Node nodeBeforeIthNode = get(i-1);
			Node ithNode = nodeBeforeIthNode.getNext();
			nodeBeforeIthNode.setNext(ithNode.getNext());
			ithNode.setNext(null);
		}
		size--;
	}

	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current!=null) {
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
	
	private void reverseRecursive(Node current) {
		if(current.getNext() == null) {
			head = current;
			return;
		}
		Node next = current.getNext();
		reverseRecursive(next);
		next.setNext(current);
		current.setNext(null);
	}

}
