package de.hska.iwi.ads.solution.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;

class BinarySearchTreeTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new BinarySearchTree<>();
    }

    @Test
    void testReplacesOldValue() {
        Map<Integer, String> map = createMap();

        assertNull(map.put(4, "old"));
        assertEquals("old", map.put(4, "new"));
        assertEquals("new", map.get(4));
        assertEquals(1, map.size());
    }

    @Test
    void testFindsLeftAndRightChildren() {
        Map<Integer, String> map = createMap();

        map.put(5, "five");
        map.put(3, "three");
        map.put(7, "seven");

        assertEquals("three", map.get(3));
        assertEquals("seven", map.get(7));
    }

    @Test
    void testMissingKeyReturnsNull() {
        Map<Integer, String> map = createMap();

        map.put(5, "five");
        map.put(3, "three");
        map.put(7, "seven");

        assertNull(map.get(4));
    }
}
