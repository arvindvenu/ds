package com.arvind.ds.singlylinkedlist;

public class Node<T> {
	
	private Node<T> next;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> n) {
		next = n;
	}
	
	public T getData() {
		return data;
	}
	
	public boolean equals(Object other) {
		Node<T> otherNode = (Node<T>)other;
		return this.data.equals(otherNode.data);
	}

}
