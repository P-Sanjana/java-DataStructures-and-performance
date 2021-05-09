/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 1, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(-1);
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		try {
			list1.remove(2);
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			shortList.add(null);
			fail("Check null element");
		}
		catch (NullPointerException e) {
			
		}
		assertEquals("AddEnd: check add ", true, shortList.add("C"));
		assertEquals("AddEnd: check get ", "C", shortList.get(2));
		assertEquals("AddEnd: check size ", 3, shortList.size);

		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size of empty list: ",0,emptyList.size());
		assertEquals("Size: check size of short list: ",2,shortList.size());
		assertEquals("Size: check size of longer list: ",10,longerList.size());
		assertEquals("Size: check size of list1",2,list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			longerList.add(-1,1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.add(0,null);
			fail("check null element");
		}
		catch(NullPointerException e){
			
		}
		try {
			shortList.add(3,"A");
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.add(longerList.size,2);
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		longerList.add(1,1);
		assertEquals("AddAtIndex: check get ",(Integer)1,longerList.get(1));
		assertEquals("AddAtIndex: check size ",2,shortList.size);
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			longerList.set(-1, 3);
			fail("check for out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	    try {
	    	shortList.set(3,"D");
	    	fail("check for out of bounds");
	    }
	    catch(IndexOutOfBoundsException e) {
	    	
	    }
	    try {
	    	longerList.set(0, null);
	    	fail("check for null element");
	    }
	    catch(NullPointerException e) {
	    	
	    }
	    assertEquals("Set: check for old value ",(Integer)0,longerList.set(0, 12));
	    assertEquals("Set: check for get ",(Integer)12,longerList.get(0));
	    assertEquals("Set: check for size ",10,longerList.size());
	}
	
	
	// TODO: Optionally add more test methods.
	
}
