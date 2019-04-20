package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

public class DoubleLinkedList implements ILinkedList {
	LinkedListNode head = new LinkedListNode(null);
	int size = 0;
	LinkedListNode tail = new LinkedListNode(null);

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
				temp1.previous = tail;
				temp1.next = null;
				tail = temp1;
			} else if (index == 0) {
				temp1.next = head;
				head.previous = temp1;
				head = temp1;
			} else {
				LinkedListNode ref = head;
				int counter = index - 1;
				boolean flag = true;
				if (index > size / 2) {
					counter = size - index;
					flag = false;
					ref = tail;
				}
				for (int i = 0; i < counter; i++) {
					if (flag) {
						ref = ref.next;
					} else {
						ref = ref.previous;
					}
				}
				temp1.next = ref.next;
				if (ref.next != null) {
					ref.next.previous = temp1;
				}
				temp1.previous = ref;
				ref.next = temp1;
			}
			size++;
		}
	}

	public void add(Object element) {
		LinkedListNode temp = new LinkedListNode(element);
		if (size == 0) {
			temp.next = null;
			head = temp;
		} else {
			temp.next = null;
			temp.previous = tail;
			tail.next = temp;
		}
		tail = temp;
		size++;
	}

	public void clear() {
		if (size == 0) {
			return;
		} else {
			head = null;
			tail = null;
			size = 0;
		}
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {

		LinkedListNode tempto = head;
		ILinkedList list = new DoubleLinkedList();
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
			if (temp.data == o) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public Object get(int index) {
		if (size <= index) {
			System.out.println("invalid index");
			return null;
		} else {
			LinkedListNode ref = head;
			int counter = index;
			boolean flag = true;
			if (index > size / 2) {
				counter = size - index - 1;
				flag = false;
				ref = tail;
			}
			for (int i = 0; i < counter; i++) {
				if (flag) {
					ref = ref.next;
				} else {
					ref = ref.previous;
				}
			}
			return ref.data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void remove(int index) {
		if (size <= index) {
			System.out.println("invalid index");
			return;
		} else if (index == 0) {
			head = head.next;
			head.previous = null;
		} else {
			int counter = index - 1;
			boolean flag = true;
			LinkedListNode ref = head;
			if (index > size / 2) {
				counter = size - index;
				flag = false;
				ref = tail;
			}

			for (int i = 0; i < counter; i++) {
				if (flag)
					ref = ref.next;
				else
					ref = ref.previous;
			}
			LinkedListNode temp = ref.next.next;
			temp.previous = ref;
			ref.next.next = null;
			ref.next.previous = null;
			ref.next = temp;
		}
		size--;
	}

	public void set(int index, Object element) {
		if (size <= index) {
			System.out.println("invalid index");
			return;
		} else {
			LinkedListNode ref = head;
			int counter = index;
			boolean flag = true;
			if (index > size / 2) {
				counter = size - index - 1;
				flag = false;
				ref = tail;
			}
			for (int i = 0; i < counter; i++) {
				if (flag) {
					ref = ref.next;
				} else {
					ref = ref.previous;
				}
			}
			ref.data = element;
		}
	}

	public int size() {
		return size;
	}

}
