package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BinaryHeapTest {

	private BinaryHeap<Integer> heap;

    @BeforeEach
    public void init() {
    	Comparator<Integer> cmp=new Comparator<Integer>() {
    		public int compare(Integer t1, Integer t2) {
    			return t1.compareTo(t2);
    		}
    	};
		this.heap = new BinaryHeap<Integer>(cmp);

    }
	@Test
	public void testConstructorException(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			BinaryHeap b=new BinaryHeap(null);
		});
	}

	@Test
	public void testPushOneElement() {
		this.heap.push(2);
		assertEquals(new Integer(2),this.heap.get(0));
	}

	@Test
	public void testPushTwoElement() {
		this.heap.push(2);
		this.heap.push(3);
		assertEquals(new Integer(3),this.heap.get(1));
	}

	@Test
	public void testPush3Element() {
		this.heap.push(2);
		this.heap.push(3);
		this.heap.push(1);
		assertEquals(new Integer(1),this.heap.get(0));
	}

	@Test
	public void testPeekWithOneElement() {
		this.heap.push(2);
		assertEquals(new Integer(2),this.heap.peek());
	}

	@Test
	public void testPeekWithNoElement() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			this.heap.peek();
		});
	}

	@Test
	public void testPeekWithMOreElement() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(1);
		assertEquals(new Integer(1),this.heap.peek());
	}

	@Test
	public void testPopWithNoElement() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			this.heap.pop();
		});
	}

	@Test
	public void testPopWithOneElement() {
		this.heap.push(1);
		assertEquals(new Integer(1),this.heap.pop());
	}

	@Test
	public void testPopWithMoreElement() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(-1);
		assertEquals(new Integer(-1),this.heap.pop());
	}

	@Test
	public void testPop2Element() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(13);
		this.heap.push(20);
		this.heap.push(3);
		this.heap.pop();
		assertEquals(new Integer(3),this.heap.pop());
	}

	@Test
	public void testPop3Element() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(13);
		this.heap.push(20);
		this.heap.push(3);
		this.heap.push(40);
		this.heap.push(50);
		this.heap.push(6);
		this.heap.pop();
		System.out.println(this.heap.peek());
		this.heap.pop();
		System.out.println(this.heap.peek());
		assertEquals(new Integer(5),this.heap.pop());
	}

	@Test
	public void testPop3ElementLastUnderRIght() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(13);
		this.heap.push(20);
		this.heap.push(3);
		this.heap.push(40);
		this.heap.push(50);
		this.heap.push(60);
		this.heap.pop();
		this.heap.pop();
		assertEquals(new Integer(5),this.heap.pop());
	}

	@Test
	public void testPopAllElement() {
		this.heap.push(2);
		this.heap.push(5);
		this.heap.push(13);
		this.heap.push(20);
		this.heap.push(3);
		this.heap.push(40);
		this.heap.push(50);
		this.heap.push(60);
		this.heap.pop();
		this.heap.pop();
		this.heap.pop();
		this.heap.pop();
		this.heap.pop();
		this.heap.pop();
		this.heap.pop();
		assertEquals(new Integer(60),this.heap.pop());
	}

	@Test
	public void testPopElementLastUnderRIght() {
		this.heap.push(2);
		this.heap.push(13);
		this.heap.push(5);
		this.heap.push(20);
		this.heap.pop();
		assertEquals(new Integer(5),this.heap.pop());
	}

	@Test
	public void testPop2SameChild() {
		this.heap.push(5);
		this.heap.push(13);
		this.heap.push(5);
		this.heap.push(5);
		this.heap.pop();
		assertEquals(new Integer(5),this.heap.pop());
	}

	@Test
	public void testGetUnder0() {
		assertEquals(null,this.heap.get(-1));
	}

	@Test
	public void testGet0() {
		assertEquals(null,this.heap.get(0));
	}

	@Test
	public void testGetSupSize() {
		assertEquals(null,this.heap.get(10));
	}

	@Test
	public void testGetSize() {
		Integer in=new Integer(3);
		this.heap.push(in);
		assertSame(in,this.heap.get(0));
	}
}
