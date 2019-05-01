package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public class LinkedListNode{
	LinkedListNode next ; 
	LinkedListNode previous ; 
	Object data ;
	public LinkedListNode (Object d) {
		data = d ;
		next = null ;
	}
	public LinkedListNode getNext () {
		return next ;
	}
	public Object getData() {
		return data ;
	}
}
