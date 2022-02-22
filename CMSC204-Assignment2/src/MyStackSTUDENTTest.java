import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackSTUDENTTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	public ArrayList<Double> fillD = new ArrayList<Double>();
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	
	@Before
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS=new MyStack<Double>(6);
		doubleS.push(14.0);
		doubleS.push(56.0);
		doubleS.push(179.0);
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
		
		//STUDENT
		assertEquals(false,doubleS.isEmpty());
		doubleS.pop();
		doubleS.pop();
		doubleS.pop();
		assertEquals(true, doubleS.isEmpty());
		
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
		
		//STUDENT
		assertEquals(false,doubleS.isFull());
		doubleS.push(48.0);
		doubleS.push(20.0);
		doubleS.push(45.0);
		assertEquals(true, doubleS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			
			
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		try {
			assertEquals(179.0, doubleS.pop(),.00);
			assertEquals(56.0, doubleS.pop(),.00);
			assertEquals(14.0, doubleS.pop(),.00);
			doubleS.pop(); //This statement should throw a stackUnderflowException
		
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}
	
	@Test
	public void testTop() throws StackOverflowException, StackUnderflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackUnderflowException, StackOverflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
		
	    //STUDENT
		doubleS.push(200.0);
		assertEquals(4, doubleS.size());
		doubleS.pop();
		assertEquals(3, doubleS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		try {
			assertEquals(true,doubleS.push(48.0));
			assertEquals(true,doubleS.push(20.0));
			assertEquals(true,doubleS.push(45.0));
			doubleS.push(10.0); //This statement should throw a StackOverflowException
			assertTrue("Should have thrown a StackOverflowException",false);
		}
		catch(StackOverflowException e) {
			assertTrue("Threw a StackOverflowException",true);
		}
		catch (Exception e) {
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}
	
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	@Test
	public void testToStringStudent() throws StackOverflowException {
		String stackString=doubleS.toString();
		assertEquals(stackString,"14.056.0179.0");
		doubleS.push(38.0);
		assertEquals(doubleS.toString(),"14.056.0179.038.0");
		
	}
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
		
		//STUDENT
		assertEquals("14.0|56.0|179.0", doubleS.toString("|"));
		doubleS.push(3.45);
		assertEquals("14.0|56.0|179.0|3.45", doubleS.toString("|"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());	
		
		//STUDENT
		fillD.add(100.0);
		fillD.add(23.0);
		fillD.add(67.0);
		//start with an empty queue
		doubleS = new MyStack<Double>(6);
		//fill with an ArrayList
		doubleS.fill(fillD);
		assertEquals(3,doubleS.size());
		assertEquals(67.0, doubleS.pop(),.0);
		assertEquals(23.0, doubleS.pop(),.0);
		assertEquals(100.0, doubleS.pop(),.0);
	}

}