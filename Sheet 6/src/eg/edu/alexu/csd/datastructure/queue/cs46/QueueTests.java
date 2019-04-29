package eg.edu.alexu.csd.datastructure.queue.cs46;

import org.junit.Assert;
import org.junit.Test;
public class QueueTests {

	@Test
	public void test1() {
		LinkedBasedQueue LQ = new LinkedBasedQueue();
		Assert.assertTrue(LQ.isEmpty());
		Assert.assertEquals(0, LQ.size());

		LQ.enqueue(5);
		LQ.enqueue(4);
		LQ.enqueue(2);
		LQ.enqueue(3);
		Assert.assertEquals(4, LQ.size());
		Assert.assertEquals(5,LQ.dequeue() );
		Assert.assertEquals(4,LQ.dequeue() );
		Assert.assertEquals(2, LQ.size());
		
		LQ.enqueue(13);
		LQ.enqueue(8);
		Assert.assertEquals(2,LQ.dequeue() );
		Assert.assertEquals(3,LQ.dequeue() );
		
		Assert.assertFalse(LQ.isEmpty());
		Assert.assertEquals(2, LQ.size());

		
		Assert.assertEquals(13,LQ.dequeue() );
		Assert.assertEquals(8,LQ.dequeue() );
		
		Assert.assertTrue(LQ.isEmpty());
		Assert.assertEquals(0, LQ.size());

	}
	@Test
	public void test2() {
		ArrayBasedQueue AQ = new ArrayBasedQueue(4);
		Assert.assertTrue(AQ.isEmpty());
		Assert.assertEquals(0, AQ.size());

		AQ.enqueue(5);
		AQ.enqueue(4);
		AQ.enqueue(2);
		AQ.enqueue(3);
		Assert.assertEquals(4, AQ.size());
		Assert.assertEquals(5,AQ.dequeue() );
		Assert.assertEquals(4,AQ.dequeue() );
		
		AQ.enqueue(13);
		AQ.enqueue(8);
		Assert.assertEquals(4, AQ.size());
		Assert.assertEquals(2,AQ.dequeue() );
		Assert.assertEquals(3,AQ.dequeue() );
		
		Assert.assertFalse(AQ.isEmpty());
		Assert.assertEquals(2, AQ.size());

		
		Assert.assertEquals(13,AQ.dequeue() );
		Assert.assertEquals(8,AQ.dequeue() );
		Assert.assertTrue(AQ.isEmpty());
		Assert.assertEquals(0, AQ.size());


	}

}
