import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {
    @Test
    void add() {
        HashSet i = new HashSet(2);
        i.add(5);
        assertEquals(i.link, 1);
        assertNotNull(i.keys[i.index(5)]);

        HashSet i1 = new HashSet(4);
        i1.add(4);
        i1.add(5);
        i1.add(1);
        i1.add(2);
        i1.add(3);
        i1.add(35);
        i1.add(-43);
        i1.add(-67);
        i1.add(29);
        i1.add(4);
        assertEquals(9, i1.link);
    }

    @Test
    void equals() {
        HashSet i = new HashSet(1);
        i.add(5);
        HashSet j = new HashSet(1);
        j.add(5);
        assertEquals(i, j);

        HashSet i1 = new HashSet(1);
        i1.add(5);
        i1.add(5);
        HashSet j1 = new HashSet(1);
        j1.add(5);
        j1.add(4);
        assertNotEquals(i1, j1);

        HashSet i2 = new HashSet(3);
        i2.add(5);
        i2.add(6);
        HashSet j2 = new HashSet(3);
        j2.add(5);
        assertNotEquals(i2, j2);

        HashSet i3 = new HashSet(1);
        i3.add(5);
        HashSet j3 = new HashSet(3);
        j3.add(5);
        assertNotEquals(i3, j3);
    }

    @Test
    void contains() {
        HashSet i = new HashSet(1);
        i.add(5);
        assertTrue(i.contains(5));

        i.add(4);
        assertTrue(i.contains(4));

        assertFalse(i.contains(7));

        i.add(10);
        assertTrue(i.contains(10));

        i.add(0);
        assertTrue(i.contains(0));


        assertTrue(i.contains(5));
        assertTrue(i.contains(4));
        assertFalse(i.contains(7));
        assertTrue(i.contains(0));
        assertTrue(i.contains(10));
    }

    @Test
    void remove() {

        HashSet i1 = new HashSet();
        i1.add(4);
        i1.add(35);
        i1.add(5);
        i1.add(1);
        i1.add(2);
        i1.add(3);
        i1.add(-43);
        i1.add(-67);
        i1.add(29);
        i1.add(4);
        assertEquals(9, i1.link);

        i1.remove(4);
        i1.remove(5);
        i1.remove(1);
        i1.remove(2);
        i1.remove(3);
        i1.remove(35);
        i1.remove(-43);
        i1.remove(-67);
        i1.remove(29);
        i1.remove(4);
        System.out.println(i1);
        assertEquals(0, i1.link);
        assertEquals(i1, new HashSet());
    }
}
