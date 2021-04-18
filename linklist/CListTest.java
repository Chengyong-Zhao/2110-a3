package linklist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CListTest {

	@Test
	public void testToString() {
		CList<Integer> list = new CList<Integer>();

		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");
		assertEquals(list.toStringR(), "[]");

		list.append(3);
		list.append(6);
		list.append(9);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[3, 6, 9]");
		assertEquals(list.toStringR(), "[9, 6, 3]");

		CList<String> listStr = new CList<>();
		listStr.append("");
		listStr.append("");
		assertEquals(listStr.size(), 2);
		assertEquals(listStr.toStringR(), "[, ]");
		assertEquals(listStr.toStringR(), "[, ]");
	}

	@Test
	public void testToStringR() {
		CList<Integer> list = new CList<Integer>();

		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");
		assertEquals(list.toStringR(), "[]");

		list.append(3);
		list.append(6);
		list.append(9);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[3, 6, 9]");
		assertEquals(list.toStringR(), "[9, 6, 3]");

		CList<String> listStr = new CList<>();
		listStr.append("");
		listStr.append("");
		assertEquals(listStr.size(), 2);
		assertEquals(listStr.toStringR(), "[, ]");
		assertEquals(listStr.toStringR(), "[, ]");
	}

	@Test
	public void testPrepend() {
		CList<Integer> list = new CList<Integer>();
		assertEquals(list.size(), 0);
		assertEquals("[]", list.toString());
		assertEquals("[]", list.toStringR());

		list.prepend(5);
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[5]");
		assertEquals(list.toStringR(), "[5]");
		assertEquals(list.head().prev().data(), 5);
		assertEquals(list.tail().next().data(), 5);

		list.prepend(7);
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[7, 5]");
		assertEquals(list.toStringR(), "[5, 7]");
		assertEquals(list.head().prev().data(), 5);
		assertEquals(list.tail().next().data(), 7);

		list.prepend(100);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[100, 7, 5]");
		assertEquals(list.toStringR(), "[5, 7, 100]");
		assertEquals(list.head().prev().data(), 5);
		assertEquals(list.tail().next().data(), 100);

		list.prepend(0);
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[0, 100, 7, 5]");
		assertEquals(list.toStringR(), "[5, 7, 100, 0]");
		assertEquals(list.head().prev().data(), 5);
		assertEquals(list.tail().next().data(), 0);
	}

	@Test
	public void testChangeHeadToNext() {
		CList<Integer> list = new CList<Integer>();
		list.changeHeadToNext();
		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]"); // empty
		assertEquals(list.toStringR(), "[]");

		list.prepend(5);
		list.changeHeadToNext();
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[5]"); // only one node
		assertEquals(list.toStringR(), "[5]");

		list.prepend(7);
		list.prepend(100);
		list.prepend(0);
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[0, 100, 7, 5]");
		assertEquals(list.toStringR(), "[5, 7, 100, 0]");

		list.changeHeadToNext();
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[100, 7, 5, 0]");
		assertEquals(list.toStringR(), "[0, 5, 7, 100]");

		list.changeHeadToNext();
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[7, 5, 0, 100]");
		assertEquals(list.toStringR(), "[100, 0, 5, 7]");

		list.changeHeadToNext();
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[5, 0, 100, 7]");
		assertEquals(list.toStringR(), "[7, 100, 0, 5]");
	}

	@Test
	public void testAppend() {
		CList<Integer> list = new CList<Integer>();
		assertEquals(list.size(), 0);
		assertEquals("[]", list.toString());
		assertEquals("[]", list.toStringR());

		list.append(5);
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[5]");
		assertEquals(list.toStringR(), "[5]");
		assertEquals(list.head().prev().data(), 5);
		assertEquals(list.tail().next().data(), 5);

		list.append(7);
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[5, 7]");
		assertEquals(list.toStringR(), "[7, 5]");

		list.append(100);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[5, 7, 100]");
		assertEquals(list.toStringR(), "[100, 7, 5]");

		list.append(0);
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[5, 7, 100, 0]");
		assertEquals(list.toStringR(), "[0, 100, 7, 5]");

		CList<String> listStr = new CList<>();
		listStr.append("AB");
		assertEquals(listStr.toString(), "[AB]");
		listStr.append(null);
		assertEquals(listStr.toString(), "[AB, null]");
	}

	@Test
	public void testGetNode() {
		CList<Integer> list = new CList<Integer>();
		list.append(5);
		list.append(7);
		list.append(100);
		list.append(0);

		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[5, 7, 100, 0]");
		assertEquals(list.toStringR(), "[0, 100, 7, 5]");

		assertEquals(list.getNode(0).data(), 5);
		assertEquals(list.getNode(1).data(), 7);
		assertEquals(list.getNode(2).data(), 100);
		assertEquals(list.getNode(3).data(), 0);

		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[5, 7, 100, 0]");
		assertEquals(list.toStringR(), "[0, 100, 7, 5]");
	}

	@Test
	public void testRemove() {
		CList<Integer> list = new CList<Integer>();
		list.append(2);
		list.remove(list.head());
		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");
		assertEquals(list.toStringR(), "[]");

		list.append(2);
		list.append(4);
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[2, 4]");
		assertEquals(list.toStringR(), "[4, 2]");

		list.remove(list.head()); // remove head node
		assertEquals(list.toString(), "[4]");
		assertEquals(list.toStringR(), "[4]");

		list.append(6);
		list.append(8);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[4, 6, 8]");
		assertEquals(list.toStringR(), "[8, 6, 4]");

		list.remove(list.head().next()); // remove middle node
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[4, 8]");
		assertEquals(list.toStringR(), "[8, 4]");

		list.remove(list.tail()); // remove tail node
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[4]");
		assertEquals(list.toStringR(), "[4]");

		list.remove(list.head());
		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");
		assertEquals(list.toStringR(), "[]");
	}

	@Test
	public void testInsertBefore() {
		CList<Character> list = new CList<Character>();
		list.prepend('c');
		list.insertBefore('v', list.head());
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[v, c]");
		assertEquals(list.toStringR(), "[c, v]");

		list.insertBefore('a', list.tail());
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[v, a, c]");
		assertEquals(list.toStringR(), "[c, a, v]");

		list.insertBefore('b', list.head().next());
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[v, b, a, c]");
		assertEquals(list.toStringR(), "[c, a, b, v]");

		list.insertBefore('z', list.tail().prev());
		assertEquals(list.size(), 5);
		assertEquals(list.toString(), "[v, b, z, a, c]");
		assertEquals(list.toStringR(), "[c, a, z, b, v]");
	}

}
