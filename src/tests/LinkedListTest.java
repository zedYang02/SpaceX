package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import lists.LinkedList;

import utility.Iterator;
import utility.List;

class LinkedListTest {

    List<String> list;

    @Test
    void testLinkedList() {
        assertNull(list);
        list = new LinkedList<String>();
        System.out.println("---------------- Test Default Constructor( ) ----------------");
        System.out.println("size before: " + list.size());
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"  ));
        assertTrue(list.add("Valerian"));

        assertEquals(4, list.size());
        System.out.println(list);
        System.out.println("size after: " + list.size());
        System.out.println();

    }

    @Test
    void testLinkedListList() {

        assertNull(list);

        System.out.println("---------------- Test Constructor List( ) ----------------");

        List<String> other = new LinkedList<String>();

        assertTrue(other.add("Augustus"));
        assertTrue(other.add("Balbinus"));
        assertTrue(other.add("Commodus"));
        assertTrue(other.add("Decius"));

        list = new LinkedList<String>(other);
        assertEquals(4, list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), other.get(i));
        }

        System.out.println(other);
        System.out.println(list);
        System.out.println();
    }

    @Test
    void testAddE() {
        assertNull(list);
        list = new LinkedList<String>();
        System.out.println("---------------- Test Add(E e) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size: " + list.size());
        assertEquals(7, list.size());
        System.out.println();
    }

    @Test
    void testAddIntE() {

        list = new LinkedList<String>();
        list.add(0,"Horus");
        list.add(1,"Isis");
        list.add("Marcus");

        System.out.println("------------ Test Add(int, E e) -----------");
        System.out.println(list);
        System.out.println();

        System.out.println("----------------- Test Add(index, value) ----------------");
        list.add(0, "Augustus");
        list.add(1, "Cresus");
        list.add(2, "Aquinas");
        System.out.println(list);
        System.out.println();

        assertEquals("Augustus", list.get(0));
        assertEquals("Cresus"  , list.get(1));
        assertEquals("Aquinas" , list.get(2));

        System.out.println("--------------------------- Add @ Location 3 -----------------------");
        list.add(3, "Commodus");
        assertEquals("Commodus", list.get(3));

        list.add(3, "Balbinus");
        assertEquals("Balbinus", list.get(3));

        list.add(3, "Eurius");
        assertEquals("Eurius"  , list.get(3));

        System.out.println(list);
        System.out.println("size: " + list.size());

        //Test if accessing index out of bounds.
        System.out.println();
    }

    @Test
    void testClear() {

        list = new LinkedList<String>();
        System.out.println("---------------- Test Clear( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertEquals(7, list.size());
        System.out.println(list);

        System.out.println("size before: " + list.size());
        list.clear();
        assertEquals(0, list.size());
        System.out.println("size after: " + list.size());

        System.out.println();
    }

    @Test
    void testContains() {
        list = new LinkedList<String>();
        System.out.println("---------------- Test Contains(E e) --------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertTrue(list.contains("Augustus"));
        assertTrue(list.contains("Commodus"));
        assertTrue(list.contains("Valerian"));
        assertFalse(list.contains("Tiberius"));

        System.out.println(list);
        System.out.println("has Commodus? " + list.contains("Commodus"));
        System.out.println("has Valerian? " + list.contains("Valerian"));
        System.out.println("has Tiberius? " + list.contains("Tiberius"));
        System.out.println();
    }

    @Test
    void testGet() {
        list = new LinkedList<String>();
        System.out.println("---------------- Test Get( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertEquals("Augustus", list.get(0));
        assertEquals("Commodus", list.get(2));
        assertEquals("Valerian", list.get(6));

        System.out.println(list);
        System.out.println("who is at 0? " + list.get(0));
        System.out.println("who is at 2? " + list.get(2));
        System.out.println("who is at 6? " + list.get(6));

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(8));
        System.out.println();
    }

    @Test
    void testIndexOf() {
        System.out.println();
        list = new LinkedList<String>();
        System.out.println("-------------- Test indexOf(E e) --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Decius");
        list.add(5, "Florianus");
        list.add(6, "Valerian");

        System.out.println(list);
        assertEquals(0,list.indexOf("Augustus"));
        assertEquals(3,list.indexOf("Commodus"));
        assertEquals(6,list.indexOf("Valerian"));
        assertEquals(-1,list.indexOf("Tiberius"));
        assertEquals(7, list.size());

        System.out.println("-----------------------------------------------");
        System.out.println("indexOf -1 \t" + list.indexOf("Tiberius"));
        System.out.println("indexOf 0 \t"  + list.indexOf("Augustus"));
        System.out.println("indexOf 2 \t"  + list.indexOf("Cresus"));
        System.out.println("indexOf 3 \t"  + list.indexOf("Commodus"));
        System.out.println("indexOf 6 \t"  + list.indexOf("Valerian"));
        list.clear();

        System.out.println(list);
        System.out.println();
    }



    @Test
    void testIsEmpty() {
        System.out.println();

        list = new LinkedList<String>();
        System.out.println("-------------- Test isEmpty() --------------");
        list.add(0,"Augustus");
        list.add(1,	"Balbinus");
        list.add(2,	"Cresus");
        list.add(3, "Commodus");
        list.add(4, "Decius");
        list.add(5, "Florianus");
        list.add(6, "Valerian");

        assertEquals(7, list.size());
        assertFalse(list.isEmpty());
        System.out.println(list);
        list.clear();

        System.out.println(list);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
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

        //TEST: ADD ELEMENT
        if (!list.contains(name1)) {
            list.add(6, name1);
        }

        assertEquals(name1, list.get(6));
        assertEquals(name2, list.get(7));
        assertEquals(8, list.size());
        System.out.println(list);
        System.out.println();

        //stores position of next element in list
        Iterator<String> itr = list.iterator();

        //START: next position = first itr position
        // next : 0   , itr : 0
        assertEquals("Augustus" ,  itr.next());		// return -> 0, position -> 1
        assertEquals("Balbinus" ,  itr.next());		// return -> 1, position -> 2
        assertEquals("Cresus"   ,  itr.next());		// return -> 2, position -> 3
        assertEquals("Commodus" ,  itr.next());		// return -> 3, position -> 4
        assertEquals("Julius"   ,  itr.next());		// return -> 4, position -> 5
        assertEquals("Septimius",  itr.next());		// return -> 5, position -> 6
        assertEquals("Tiberius" ,  itr.next());		// return -> 6, position -> 7
        assertEquals("Valerian" ,  itr.next());		// return -> 7, position -> 8

        // No more elements to retrieve will throw Exception
        assertThrows(NoSuchElementException.class, itr::next);
        System.out.println();
    }

    @Test
    void testLinkedIteratorLoop() {

        assertNull(list);
        list = new LinkedList<String>();
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

        if (itr.hasNext())
            assertThrows(IllegalStateException.class, itr::remove);

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
        LinkedList<String> list = new LinkedList<String>();
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
        LinkedList<String> list = new LinkedList<String>();
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

    @Test
    void testRemoveIntegerList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println("---------------- Test RemoveIntegers() ----------------");
        assertTrue(list.add(1));
        assertTrue(list.add(3));
        assertTrue(list.add(5));
        assertTrue(list.add(7));
        assertTrue(list.add(9));
        assertTrue(list.add(11));
        assertTrue(list.add(13));
        assertTrue(list.add(15));
        assertTrue(list.add(17));
        assertTrue(list.add(19));
        assertTrue(list.add(21));

        System.out.println(list);
        System.out.println("size before: " + list.size());
        assertEquals(7  , list.remove(3));
        assertEquals(9  , list.remove(3));
        assertEquals(11 , list.remove(3));
        assertTrue(list.remove(Integer.valueOf(3)));
        assertTrue(list.remove(Integer.valueOf(1)));
        assertTrue(list.remove(Integer.valueOf(21)));
        System.out.println(list);
        System.out.println("size after: " + list.size());

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(8));
        System.out.println();
    }

    @Test
    void testSet() {
        LinkedList<String> list = new LinkedList<String>();
        System.out.println("------------------ Test Set( ) ------------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        assertEquals("Balbinus", list.set(1, "Julius"));
        System.out.println(list);
        assertEquals("Decius"  , list.set(3, "Tiberius"));
        System.out.println(list);
        System.out.println();

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-2, "Hera"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(8, "Hera"));
    }

    @Test
    void testSize() {

        LinkedList<String> list = new LinkedList<String>();
        System.out.println("---------------- Test Size() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        assertEquals(5, list.size());
        System.out.println("size end: " + list.size());

        System.out.println();
    }

}
