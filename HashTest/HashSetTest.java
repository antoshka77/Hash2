import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {
    @Test
    void add() {
        HashSet i = new HashSet(0);
        i.add(5);
        assertEquals(5, i.keys[0]);

        HashSet i1 = new HashSet(2);
        i1.add(4);
        i1.add(5);
        i1.add(1);
        i1.add(2);
        i1.add(3);
        int ind = Math.abs(hash(4)) % 2;
        assertEquals(4, i1.keys[ind]);
    }

    @Test
    void equals() {
        HashSet i = new HashSet(1);
        i.add(5);
        HashSet j = new HashSet(1);
        j.add(5);
        assertTrue(i.equals(j));

        HashSet i1 = new HashSet(1);
        i1.add(5);
        i1.add(5);
        HashSet j1 = new HashSet(1);
        j1.add(5);
        j1.add(4);
        assertFalse(i1.equals(j1));

        HashSet i2 = new HashSet(3);
        i2.add(5);
        i2.add(6);
        HashSet j2 = new HashSet(3);
        j2.add(5);
        assertFalse(i2.equals(j2));

        HashSet i3 = new HashSet(1);
        i3.add(5);
        HashSet j3 = new HashSet(3);
        j3.add(5);
        assertFalse(i3.equals(j3));
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
    }



    private int hash(int x) {
        return (x >> 15) ^ x;
    }
}
