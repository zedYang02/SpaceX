package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import lists.ArrayList;
import lists.LinkedList;
import utility.List;
import utility.Iterator;

class IteratorTest {

	List<String> list;
	
    @Test
    void testArrayIterator() {
        list = new ArrayList<String>();
        System.out.println("-------------- Test ArrayList Iterator() --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Julius");
        list.add(5, "Septimius");
        list.add(6, "Valerian");
        System.out.println(list);

        String name1 = "Tiberius";
        String name2 = "Valerian";

        if (!list.contains(name1)) {
            list.add(6, name1);
        }

        assertEquals(name1, list.get(6));
        assertEquals(name2, list.get(7));
        System.out.println(list);
        System.out.println();

        Iterator<String> itr = list.iterator();
        assertEquals("Augustus" ,  itr.next());
        assertEquals("Balbinus" ,  itr.next());
        assertEquals("Cresus"   ,  itr.next());
        assertEquals("Commodus" ,  itr.next());
        assertEquals("Julius"   ,  itr.next());
        assertEquals("Septimius",  itr.next());
        assertEquals("Tiberius" ,  itr.next());
        assertEquals("Valerian" ,  itr.next());

    }

    @Test
    void testAIteratorLoop() {
        list = new ArrayList<String>();
        System.out.println("-------------- Test Array Iterator Loop() --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Julius");
        list.add(5, "Septimius");
        list.add(6, "Tiberius");
        list.add(7, "Valerian");
        System.out.println(list);

        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            assertTrue(itr.hasNext());
            System.out.print("hasNext: " + itr.hasNext());
            System.out.println("\t next: " + itr.next());
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();
    }


    @Test
    void testLinkedIterator() {
        list = new LinkedList<String>();
        System.out.println("-------------- Test LinkedList Iterator() --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Julius");
        list.add(5, "Septimius");
        list.add(6, "Valerian");
        System.out.println(list);

        String name1 = "Tiberius";
        String name2 = "Valerian";

        if (!list.contains(name1)) {
            list.add(6, name1);
        }

        assertEquals(name1, list.get(6));
        assertEquals(name2, list.get(7));
        System.out.println(list);
        System.out.println();

        Iterator<String> itr = list.iterator();
        assertEquals("Augustus" ,  itr.next());
        assertEquals("Balbinus" ,  itr.next());
        assertEquals("Cresus"   ,  itr.next());
        assertEquals("Commodus" ,  itr.next());
        assertEquals("Julius"   ,  itr.next());
        assertEquals("Septimius",  itr.next());
        assertEquals("Tiberius" ,  itr.next());
        assertEquals("Valerian" ,  itr.next());
    }

    @Test
    void testLLIteratorLoop() {
        list = new LinkedList<String>();
        System.out.println("-------------- Test Linked Iterator Loop() --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Julius");
        list.add(5, "Septimius");
        list.add(6, "Tiberius");
        list.add(7, "Valerian");
        System.out.println(list);

        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            assertTrue(itr.hasNext());
            System.out.print("hasNext: " + itr.hasNext());
            System.out.println("\t next: " + itr.next());
        }

        // At end of the list : No more elements
        assertFalse(itr.hasNext());

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();
    }

    @Test
    void testRemoveE() {
        list = new LinkedList<String>();
        System.out.println("---------------- Test RemoveE() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Septimius"));
        assertTrue(list.add("Tiberius"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size before: " + list.size());

        assertTrue(list.remove("Decius"));
        assertTrue(list.remove("Commodus"));
        assertTrue(list.remove("Gallienus"));
        assertTrue(list.remove("Balbinus"));
        assertTrue(list.remove("Augustus"));
        assertFalse(list.remove("Decius"));
        assertTrue(list.remove("Septimius"));

        System.out.println(list);
        assertTrue(list.remove("Valerian"));
        System.out.println("size after: " + list.size());

        assertFalse(list.remove("Florianus"));
        System.out.println(list);
        System.out.println("size after Flo: " + list.size());
        System.out.println();
    }

    @Test
    void testRemoveInt() {

        System.out.println();
        list = new LinkedList<String>();
        System.out.println("---------------- Test RemoveInt() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Septimius"));
        assertTrue(list.add("Tiberius"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size before: " + list.size());
        assertEquals("Augustus" , list.remove(0));
        assertEquals("Decius"   , list.remove(2));
        assertEquals("Gallienus", list.remove(2));
        assertEquals("Balbinus" , list.remove(0));
        assertEquals("Commodus" , list.remove(0));
        assertEquals("Valerian" , list.remove(2));
        System.out.println(list);
        System.out.println("size after: " + list.size());

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
        System.out.println();
    }

}
