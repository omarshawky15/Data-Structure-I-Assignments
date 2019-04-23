package eg.edu.alexu.csd.datastructure.stack.cs46;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45.*;

public class Stack implements IStack {
	LinkedListNode top = null;
	int size = 0;

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object o = top.data;
		top = top.next;
		size--;
		return o;
	}

	public Object peek() {
		if (size == 0)
			throw new EmptyStackException();
		return top.data;
	}

	public void push(Object element) {
		LinkedListNode n = new LinkedListNode(element);
		n.next = top;
		top = n;
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
