package com.arvind.ds;

public class LinkedList {
	int size = 0;
	Node head;

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
		return get(i,0,head);
	}
	
	private Node get(int i, int currPos, Node currentNode) {
		if(currPos == i) {
			return currentNode;
		}
		return get(i, currPos+1, currentNode.getNext());
	}

}
