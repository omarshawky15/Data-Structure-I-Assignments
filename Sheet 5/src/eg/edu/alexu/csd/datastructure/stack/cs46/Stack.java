package eg.edu.alexu.csd.datastructure.stack.cs46;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45.*;

public class Stack implements IStack {
	LinkedListNode top = null;
	int size = 0;
	/**
	* Removes the element at the top of stack and returns that element.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object o = top.data;
		top = top.next;
		size--;
		return o;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/

	public Object peek() {
		if (size == 0)
			throw new EmptyStackException();
		return top.data;
	}
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param object
	* to insert
	*/
	public void push(Object element) {
		LinkedListNode n = new LinkedListNode(element);
		n.next = top;
		top = n;
		size++;
	}
	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/

	public boolean isEmpty() {
		return size == 0;
	}
	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
	public int size() {
		return size;
	}
}
