import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  
 *  Ellen Joyce
 */

@RunWith(JUnit4.class)
public class BSTTest
{

	//TODO write more tests here.
	@Test 
	public void testSelect(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7,7);
		bst.put(6, 6);
		bst.put(3, 3);
		assertEquals("Check that select() returns 3 when looking for first node in tree", 3, (int)bst.select(0));
		assertEquals("Check that select() returns 6 when looking for second node in tree", 6, (int)bst.select(1));
		assertEquals("Check that select() returns 7 when looking for third node in tree", 7, (int)bst.select(2));
		assertEquals("Check that select() returns null when looking for fourth node in tree with three nodes", null, bst.select(4));

	}
	@Test
	public void testHeight(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Check that height() returns -1 when the tree is empty",-1,bst.height());
		bst.put(7,null);
		bst.put(7,6);
		bst.put(7,7);
		assertEquals("Checking that height() returns 0 when there is only one node in the tree", 0, bst.height());
		bst.put(6, 6);
		bst.put(3, 3);
		assertEquals("Checking that height() returns 2 when there are three nodes in the tree", 2, bst.height());
	}
	@Test
	public void testHeightWhenTreeIsBalanced(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(4,4);
		bst.put(2, 2);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(3, 3);
		bst.put(5, 5);
		bst.put(7, 7);
		assertEquals("Checking that height() returns 2 when there are 7 nodes and the tree is balanced", 2, bst.height());

	}
	@Test
	public void testRank(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Check that rank(key) returns 0 for the list is empty", 0, bst.rank(3));
		bst.put(4,4);
		assertEquals("Check that rank(key) returns 0 for the rank of the root when the root is the tree", 0, bst.rank(4));
		bst.put(3, 3);
		bst.put(5, 5);
		assertEquals("Check that rank(key) returns 0 for the rank of the first node in the tree", 0, bst.rank(3));
		assertEquals("Check that rank(key) returns 1 for the rank of the root when the root is the second node", 1, bst.rank(4));
		assertEquals("Check that rank(key) returns 2 for the rank of the last node in the tree", 2, bst.rank(5));

	}
	@Test
	public void testMedian(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Check that median() returns null when the tree is empty",null,bst.median());
		bst.put(7,7);
		assertEquals("Check that median() returns 7 when the root is the tree", 7,(int)bst.median());
		bst.put(5, 5);
		bst.put(8, 8);
		assertEquals("Check that median() returns 7 when the root is the median", 7,(int)bst.median());
		bst.put(3, 3);
		bst.put(6, 6);
		assertEquals("Check that median() returns 6 when the right child node is the median", 6, (int)bst.median());


	}
	@Test
	public void testPut(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(4,null);
		assertEquals("Test that put() does nothing if the value is null","()",bst.printKeysInOrder());
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(6, 6);
		bst.put(5, 5);
		bst.put(7, 7);		
		bst.put(3, 3);
		assertEquals("Check that put() inserts nodes correctly","(((()1())2(()3()))4((()5())6(()7())))",bst.printKeysInOrder());



	}
	@Test
	public void testSize(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Check that size() returns 0 when the tree is empty",0,bst.size());
		bst.put(7,7);
		assertEquals("Check that size() returns 1 when the tree has a root",1,bst.size());
		bst.put(8, 8);
		assertEquals("Check that size returns 2 when there is a root and a right child node",2,bst.size());
		bst.put(3, 3);
		assertEquals("Check that size returns 2 when there is a root, a left child node and a right child node",3,bst.size());
	}
	@Test 
	public void testContains(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertFalse("Checking contains() returns true when bst is empty",bst.contains(4));
		bst.put(7,7);
		assertFalse("Checking contains() returns false when bst isn't empty but doesn't contain the key",bst.contains(1));
		assertTrue("Checking contains() retuns true when bst isn't empty and conatins the key",bst.contains(7));
	}
	@Test
	public void testGet(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Check that get() returns null when given an empty list", null, bst.get(9));
		bst.put(4, 4);
		bst.put(2, 2);
		bst.put(7, 7);
		assertEquals("Check that get() returns 4 when given 4", 4, (int)bst.get(4));
		assertEquals("Check that get() returns 7 when given 7", 7, (int)bst.get(7));
		assertEquals("Check that get() returns 2 when given 2", 2, (int)bst.get(2));
		assertEquals("Check that get() returns null when the key does not exist", null, bst.get(9));

	}
	@Test 
	public void testIsEmpty(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertTrue("Checking isEmpty() returns true when bst is empty",bst.isEmpty());
		bst.put(7,7);
		assertFalse("Checking isEmpty() returns false when bst isn't empty",bst.isEmpty());
	}

	/** <p>Test {@link BST#prettyPrintKeys()}.</p> */

	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree","-null\n", bst.prettyPrintKeys());

		//  -7
		//   |-3
		//   | |-1
		//   | | |-null
		bst.put(7, 7);       //   | |  -2
		bst.put(8, 8);       //   | |   |-null
		bst.put(3, 3);       //   | |    -null
		bst.put(1, 1);       //   |  -6
		bst.put(2, 2);       //   |   |-4
		bst.put(6, 6);       //   |   | |-null
		bst.put(4, 4);       //   |   |  -5
		bst.put(5, 5);       //   |   |   |-null
		//   |   |    -null
		//   |    -null
		//    -8
		//     |-null
		//      -null

		String result = 
				"-7\n" +
						" |-3\n" + 
						" | |-1\n" +
						" | | |-null\n" + 
						" | |  -2\n" +
						" | |   |-null\n" +
						" | |    -null\n" +
						" |  -6\n" +
						" |   |-4\n" +
						" |   | |-null\n" +
						" |   |  -5\n" +
						" |   |   |-null\n" +
						" |   |    -null\n" +
						" |    -null\n" +
						"  -8\n" +
						"   |-null\n" +
						"    -null\n";
		assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	}


	/** <p>Test {@link BST#delete(Comparable)}.</p> */
	@Test
	public void testDelete() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.delete(1);
		assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		//         5

		assertEquals("Checking order of constructed tree",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(9);
		assertEquals("Deleting non-existent key",
				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

		bst.delete(8);
		assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

		bst.delete(6);
		assertEquals("Deleting node with single child",
				"(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

		bst.delete(3);
		assertEquals("Deleting node with two children",
				"(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	}

}

