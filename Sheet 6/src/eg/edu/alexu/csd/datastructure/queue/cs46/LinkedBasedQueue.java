package eg.edu.alexu.csd.datastructure.queue.cs46;

import java.util.NoSuchElementException;

public class LinkedBasedQueue implements IQueue, ILinkedBased {
	public class LinkedListNode {
		public LinkedListNode next;
		public Object data;

		public LinkedListNode(Object d) {
			data = d;
			next = null;
		}
	}

	LinkedListNode  begin = null , end= null;
	int size = 0;

	/**
	 * Inserts an item at the queue front.
	 * 
	 * @param item object which will be inserted
	 */
	public void enqueue(Object item) {
		if (isEmpty()) {
			begin = new LinkedListNode(item);
			end = begin;
		}
		else {
			end.next = new LinkedListNode(item);
			end = end.next;
		}
		size++;
	}
	/**
	* Removes the object at the queue rear.
	* @return object at queue rear
	*/
	public Object dequeue() {
		if(isEmpty())throw new NoSuchElementException();
		else {
			Object temp = begin.data ;
			begin=begin.next;
			size--;
			if(isEmpty())end=null;
			return temp ;
		}
	}

	/**
	 * Tests if this queue is empty.
	 * 
	 * @return true is empty , false otherwise
	 */

	public boolean isEmpty() {
		return size == 0;
	}
	/**
	* Returns the number of elements in the queue
	*/
	public int size() {
		return size;
	}
}
