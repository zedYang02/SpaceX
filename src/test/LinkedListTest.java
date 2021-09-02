package test;

import lists.LinkedList;
import utility.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list;
		List<String> other = new LinkedList<String>();
		other.add("Tom");
		other.add("Som");

		other.add("Jom");
		list = new LinkedList<String>(other);
		System.out.println(list);

	}

}
