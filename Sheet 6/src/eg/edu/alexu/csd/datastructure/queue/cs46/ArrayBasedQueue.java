package eg.edu.alexu.csd.datastructure.queue.cs46;

import java.util.NoSuchElementException;

public class ArrayBasedQueue implements IQueue, IArrayBased {
	int n, f = 0, r = 1;
	Object[] arr = null;
/**
 * casting
 * @param n size of Queue
 */
	ArrayBasedQueue(int n) {
		this.arr = new Object[n+1];
		this.n = n+1;
	}
	/**
	 * casting in n = null 
	 */
	ArrayBasedQueue() {
		this(1000);
	}

	/**
	 * Inserts an item at the queue front.
	 * 
	 * @param item object which will be inserted
	 */
	public void enqueue(Object item) {
		if (size() != n-1){
			arr[r] = item;
			r=(r+1)%n;
		}
		else throw new IllegalStateException("Queue is full"); 
	}
	/**
	* Removes the object at the queue rear.
	* @return object at queue rear
	*/
	public Object dequeue() {
		if(isEmpty())throw new NoSuchElementException("Queue is empty");
		else {
			f= (f+1)%n;
			Object temp = arr[f] ;
			arr[f] = null ;
			return temp ;
		}
	}
	/**
	* Tests if this queue is empty.
	* @return true is empty , false otherwise
	*/

	public boolean isEmpty() {
		return r==f+1 ;
	}
	/**
	* @Returns the number of elements in the queue
	*/
	public int size() {
		return (n-f+(r-1))%n ;
	}
}
