package com.bootcamp.week2.ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<T> implements Iterable<T> {

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = top;
		top = newNode;
	}

	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}

		T value = top.data;
		top = top.next;
		return value;
	}

	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	private class StackIterator implements Iterator<T> {
		private Node<T> current = top;

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			T data = current.data;
			current = current.next;
			return data;
		}
	}

	public Iterator<T> iterator() {
		return new StackIterator();
	}
}


