package eg.edu.alexu.csd.datastructure.linkedList.cs46_cs45;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SingleLinkedListTester {

	@Test
	void testAdd() {
		SingleLinkedList test = new SingleLinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ArrayList<Object> testArr = new ArrayList<Object>();
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		testArr.add(5);
		for (int i = 0; i < testArr.size(); i++) {
			Assert.assertEquals("wrong", test.get(i), testArr.get(i));
		}
	}

	@Test
	void testAddAtIndext() {
		SingleLinkedList test = new SingleLinkedList();
		test.add(5, 1);
		test.add(1, 2);
		test.add(0, 3);
		test.add(1, 4);
		test.add(2, 5);

		ArrayList<Object> testArr = new ArrayList<Object>();
		testArr.add(0, 3);
		testArr.add(1, 4);
		testArr.add(2, 5);

		for (int i = 0; i < testArr.size(); i++) {
			Assert.assertEquals("wrong", test.get(i), testArr.get(i));
		}
		testArr.add(1, 7);
		test.add(1, 7);
		Assert.assertEquals("wrong", test.get(1), testArr.get(1));
	}

	@Test
	void testclear() {
		SingleLinkedList test = new SingleLinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.clear();
		Assert.assertTrue(test.size == 0);
		Assert.assertTrue(test.get(2) == null);
	}

	@Test
	void testcontains() {
		SingleLinkedList test = new SingleLinkedList();
		Object o = 3;
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		Object removedNode = test.get(3);
		test.remove(3);
		Assert.assertFalse(test.contains(removedNode));
		Assert.assertTrue(test.contains(o));
	}

	@Test
	void testremove() {
		SingleLinkedList test = new SingleLinkedList();
		int sizebefore, sizeafter;
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		sizebefore = test.size;
		Object removedNode = test.get(3);
		test.remove(3);
		sizeafter = test.size;
		Assert.assertFalse(removedNode == test.get(3));
		Assert.assertEquals(sizeafter, sizebefore - 1);
	}

	@Test
	void testsetget() {
		SingleLinkedList test = new SingleLinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		ArrayList<Object> testArr = new ArrayList<Object>();
		testArr.add(1);
		testArr.add(2);
		testArr.add(3);
		testArr.add(4);
		testArr.add(5);
		Assert.assertTrue(test.get(7) == null);
		test.set(3, 6);
		testArr.set(3, 6);
		Assert.assertEquals("wrong set", test.get(3), testArr.get(3));
	}

	@Test
	void testsublist() {
		SingleLinkedList test = new SingleLinkedList();
		ILinkedList list1 = new SingleLinkedList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		int fromindex = 0, toindex = 5;
		list1 = test.sublist(fromindex, toindex);
		for (int i = fromindex; i < toindex; i++) {
			Assert.assertTrue(test.get(i) == list1.get(i - fromindex));
		}
	}
}
