package eg.edu.alexu.csd.datastructure.queue.cs46;

public interface IQueue {
	/**
	* Inserts an item at the queue front.
	* @param item object which will be inserted
	*/
	public void enqueue(Object item);
	/**
	* Tests if this queue is empty.
	* @return true is empty , false otherwise
	*/

	public boolean isEmpty() ;
	/**
	* Removes the object at the queue rear.
	* @return object at queue rear
	*/
	public Object dequeue();
	/**
	* @Returns the number of elements in the queue
	*/
	public int size();
}
