import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedQueue {

	DequeI<String> deque;

	@Before
	public void setUp() {
		deque = new DoubleLinkedDeque<String>();
		deque.addToFront("An");
		deque.addToBack("Bob");
	}

	@Test
	public void testGetBackAndFront() {
		assertEquals(deque.getFront(), "An");
		assertEquals(deque.getBack(), "Bob");
	}

	@Test
	public void testIsEmpty() {
		deque.removeFront();
		deque.removeBack();
		assertTrue(deque.isEmpty());
	}

	@Test
	public void testClear() {
		deque.clear();
		assertTrue(deque.isEmpty());
	}

}
