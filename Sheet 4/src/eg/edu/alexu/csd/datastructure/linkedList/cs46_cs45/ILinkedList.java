package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public interface ILinkedList {
	LinkedListNode head = new LinkedListNode(null);
	int size = 0;
	LinkedListNode tail = new LinkedListNode(null);

	public void add(int index, Object element);

	public void add(Object element);

	public void clear();

	public boolean contains(Object o);

	public Object get(int index);

	public boolean isEmpty();

	public void set(int index, Object element);

	public int size();

}
