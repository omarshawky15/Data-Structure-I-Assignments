package eg.edu.alexu.csd.datastructure.stack.cs46;

import org.junit.Assert;
import org.junit.Test;

public class StackTester {
	

	@Test
	public void testpeek() {
		Stack tester = new Stack();
		tester.push(5);
		tester.push(3);
		tester.push(1);
		tester.push(12);

		Assert.assertEquals(12, tester.peek());
		Assert.assertEquals(12, tester.peek());
		Assert.assertEquals(4, tester.size());
	}

	@Test
	public void testpoppush() {
		Stack tester = new Stack();
		int size;
		tester.push(5);
		tester.push(3);
		tester.push(1);
		tester.push(12);
		Assert.assertEquals(12, tester.pop());
		Assert.assertEquals(1, tester.pop());
		Assert.assertEquals(3, tester.pop());
		size  = 1;
		Assert.assertEquals(size, tester.size());
		tester.push(7);
		tester.push(10);
		size =3 ;
		Assert.assertEquals(size, tester.size());
		Assert.assertEquals(10, tester.peek());

	}

	
	@Test
	public void testisEmpty() {
		Stack tester = new Stack();
		Assert.assertTrue(tester.isEmpty());
	}
}