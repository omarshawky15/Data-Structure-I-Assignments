package eg.edu.alexu.csd.datastructure.queue.cs46_cs56;

import java.util.NoSuchElementException;

public class ArrayBasedQueue implements IQueue, IArrayBased {
	public int n, f = -1, r = 0 , size =0;
	public Object[] arr = null;
/**
 * casting
 * @param n size of Queue
 */
	ArrayBasedQueue(int n) {
		this.arr = new Object[n];
		this.n = n;
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
		if (size() != n){
			arr[r] = item;
			r=(r+1)%n;
			size++;
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
			size-- ;
			return temp ;
		}
	}
	/**
	* Tests if this queue is empty.
	* @return true is empty , false otherwise
	*/

	public boolean isEmpty() {
		return size() == 0 ;
	}
	/**
	* @Returns the number of elements in the queue
	*/
	public int size() {
		return size ;
	}
}
