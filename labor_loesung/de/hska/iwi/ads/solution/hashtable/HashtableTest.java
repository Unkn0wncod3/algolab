package de.hska.iwi.ads.solution.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.AbstractDictionary.DictionaryFullException;
import de.hska.iwi.ads.dictionary.MapTest;

class HashtableTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new Hashtable<>(31);
    }

    @Test
    void testFindsCollidingKeys() {
        Map<Integer, String> map = new Hashtable<>(11);

        map.put(0, "Alice");
        map.put(11, "Bob");
        map.put(22, "Clara");

        assertEquals("Alice", map.get(0));
        assertEquals("Bob", map.get(11));
        assertEquals("Clara", map.get(22));
    }

    @Test
    void testReplacesOldValue() {
        Map<Integer, String> map = new Hashtable<>(11);

        assertNull(map.put(5, "old"));
        assertEquals("old", map.put(5, "new"));
        assertEquals("new", map.get(5));
        assertEquals(1, map.size());
    }

    @Test
    void testFullTableThrowsException() {
        Map<Integer, String> map = new Hashtable<>(2);

        map.put(0, "first");
        map.put(1, "second");

        assertThrows(DictionaryFullException.class, () -> map.put(2, "third"));
    }
}
