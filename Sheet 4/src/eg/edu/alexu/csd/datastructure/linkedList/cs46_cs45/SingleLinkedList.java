package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public class SingleLinkedList implements ILinkedList {
	LinkedListNode head = new LinkedListNode(null);
	int size = 0;
	LinkedListNode tail = new LinkedListNode(null);

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void add(int index, Object element) {
		if (size < index) {
			System.out.println("invalid index");
			return;
		} else {
			LinkedListNode temp1 = new LinkedListNode(element);
			if (size == 0) {
				head = temp1;
				tail = temp1;
			}
			// so to avoid O(n) complexity if it was to add at the end we will add after
			// tail
			else if (size == index) {
				tail.next = temp1;
				tail = temp1;
				temp1.next = null;
			} else if (index == 0) {
				temp1.next = head;
				head = temp1;
			} else {
				LinkedListNode ref = head;
				int counter = index - 1;
				for (int i = 0; i < counter; i++) {
					ref = ref.next;
				}
				temp1.next = ref.next;
				ref.next = temp1;
			}
			size++;
		}
	}

	public void add(Object element) {
		if (size == 0) {
			LinkedListNode temp = new LinkedListNode(element);
			temp.next = null;
			head = temp;
			tail = temp;
			size++;
		} else {
			LinkedListNode temp = new LinkedListNode(element);
			temp.next = null;
			tail.next = temp;
			tail = temp;
			size++;
		}
	}

	public Object get(int index) {
		LinkedListNode temp = head;
		if (size <= index) {
			System.out.println("invalid index");
			return null;
		}
		while (index > 0) {
			index--;
			temp = temp.next;
		}
		return temp.data;
	}

	public void set(int index, Object element) {
		if (size <= index) {
			System.out.println("invalid index");
			return;
		}
		LinkedListNode temp = head;
		while (index > 0) {
			index--;
			temp = temp.next;
		}
		temp.data = element;
	}

	public void clear() {
		if (size == 0)
			return;
		else {
			head = null;
			tail = null;
			size = 0;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void remove(int index) {
		if (size <= index) {
			System.out.println("invalid index");
			return;
		} else if (index == 0)
			head = head.next;
		else {
			LinkedListNode temp1 = head;
			for (int i = 1; i < index; i++) {
				temp1 = temp1.next;
			}
			LinkedListNode temp2 = temp1.next.next;
			temp1.next.next = null;
			temp1.next = temp2;

		}
		size--;
	}

	public int size() {
		return size;
	}

	
	public ILinkedList sublist(int fromIndex, int toIndex) {

		LinkedListNode tempto = head;
		ILinkedList list = new SingleLinkedList();
		for (int i = 0; i < toIndex; i++) {
			if (i >= fromIndex) {
				list.add(tempto.getData());
			}
			tempto = tempto.next;
		}

	  return list ; 
	  }
	 
	public boolean contains(Object o) {
		LinkedListNode temp = head;
		while (temp != null) {
			if (temp.data == o)
				return true;
			temp = temp.next;
		}
		return false;
	}

}
