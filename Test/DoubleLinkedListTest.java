

import de.hawh.ld.dll.DoubleLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    private List<Integer> intTestData = List.of(1, 2, 3, 4, 5, 6);
    private List<String> strTestData = List.of("H", "e", "l", "l", "o", "!");
    private DoubleLinkedList<Integer> intDLL = new DoubleLinkedList<>();
    private DoubleLinkedList<String> strDLL = new DoubleLinkedList<>();
    private DoubleLinkedList<String> emptyDLL = new DoubleLinkedList<>();
    private DoubleLinkedList<Integer> identicalIntDLL = new DoubleLinkedList<>();
    private DoubleLinkedList<String> identicalStrDLL = new DoubleLinkedList<>();
    private DoubleLinkedList<String> identicalEmptyDLL = new DoubleLinkedList<>();


    @BeforeEach
    void setUp() {
        for (Integer i : intTestData) {
            intDLL.add(i);
            identicalIntDLL.add(i);
        }
        for (String str : strTestData) {
            strDLL.add(str);
            identicalStrDLL.add(str);
        }
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void testAdd() {
        intDLL.add(7);
        assertEquals(7, intDLL.size());
        assertTrue(intDLL.includes(7));

        strDLL.add("?");
        assertEquals(7, strDLL.size());
        assertTrue(strDLL.includes("?"));

    }

    @Test
    public void testDeleteFirst() {
        intDLL.deleteFirst();
        assertEquals(5, intDLL.size());
        assertFalse(intDLL.includes(1));
        strDLL.deleteFirst();
        assertEquals(5, strDLL.size());
        assertFalse(strDLL.includes("H"));

        assertThrows(NoSuchElementException.class, () -> emptyDLL.deleteFirst());
    }



    @Test
    public void testDeleteLast() {
        intDLL.deleteLast();
        assertEquals(5, intDLL.size());
        assertFalse(intDLL.includes(6));
        strDLL.deleteLast();
        assertEquals(5, strDLL.size());
        assertFalse(strDLL.includes("!"));

        assertThrows(NoSuchElementException.class, () -> emptyDLL.deleteLast());
    }

    @Test
    public void testDeleteAt() {
        intDLL.deleteAt(2);
        assertEquals(5, intDLL.size());
        assertFalse(intDLL.includes(3));
        strDLL.deleteAt(1);
        assertEquals(5, strDLL.size());
        assertFalse(strDLL.includes("e"));

        assertThrows(IndexOutOfBoundsException.class, () -> emptyDLL.deleteAt(2));
    }

    @Test
    public void testRemoveAt() {
        intDLL.removeAt(2);
        assertEquals(6, intDLL.size());
        assertFalse(intDLL.includes(3));
        strDLL.removeAt(1);
        assertEquals(6, strDLL.size());
        assertFalse(strDLL.includes("e"));

        assertThrows(IndexOutOfBoundsException.class, () -> emptyDLL.deleteAt(2));
    }

    @Test
    public void testAddAt() {
        intDLL.addAt(2, 42);
        assertEquals(7, intDLL.size());
        assertTrue(intDLL.includes(42));
        assertEquals(3, intDLL.readAt(3));

        strDLL.addAt(2, "World");
        assertEquals(7, strDLL.size());
        assertTrue(strDLL.includes("World"));
        assertEquals("World", strDLL.readAt(2));

        assertThrows(IndexOutOfBoundsException.class, () -> emptyDLL.addAt(2, "test"));

    }

    @Test
    public void testIncludes() {
        assertTrue(intDLL.includes(6));
        intDLL.deleteLast();
        assertFalse(intDLL.includes(6));

        assertTrue(strDLL.includes("!"));
        strDLL.deleteLast();
        assertFalse(strDLL.includes("!"));

        assertFalse(emptyDLL.includes("!"));
    }

    @Test
    public void testReadAt() {
        assertEquals(3, intDLL.readAt(2));
        assertEquals("e", strDLL.readAt(1));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyDLL.readAt(2));


    }

    @Test
    public void testSize() {
        assertEquals(6, intDLL.size());
        assertEquals(6, strDLL.size());
        assertEquals(0, emptyDLL.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(emptyDLL.isEmpty());
        assertFalse(intDLL.isEmpty());
        assertFalse(strDLL.isEmpty());
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testEquals(){
        assertEquals(intDLL, identicalIntDLL);
        intDLL.deleteLast();
        intDLL.addAt(5, 7);
        assertNotEquals(intDLL, identicalIntDLL);

        assertEquals(strDLL, identicalStrDLL);
        strDLL.deleteLast();
        assertNotEquals(strDLL, identicalStrDLL);

        assertEquals(emptyDLL, identicalEmptyDLL);
        emptyDLL.add("test");
        assertNotEquals(emptyDLL, identicalEmptyDLL);

        assertNotEquals(intDLL,strDLL);

    }

    @Test
    public void testHashCode(){
        assertEquals(intDLL.hashCode(), identicalIntDLL.hashCode());
        intDLL.deleteLast();
        assertNotEquals(intDLL.hashCode(), identicalIntDLL.hashCode());

        assertEquals(strDLL.hashCode(), identicalStrDLL.hashCode());
        strDLL.deleteLast();
        assertNotEquals(strDLL.hashCode(), identicalStrDLL.hashCode());

        assertEquals(emptyDLL.hashCode(), identicalEmptyDLL.hashCode());
        emptyDLL.add("test");
        assertNotEquals(emptyDLL.hashCode(), identicalEmptyDLL.hashCode());
    }
}