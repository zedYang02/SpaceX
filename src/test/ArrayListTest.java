package test;

import lists.ArrayList;
import utility.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> other = new ArrayList<String>();
		other.add("Tom");
		other.add("Som");

		other.add("Jom");

		ArrayList<String> list = new ArrayList<String>(other);
		System.out.println(list);

	}

}
