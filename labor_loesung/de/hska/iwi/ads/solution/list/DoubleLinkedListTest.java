package de.hska.iwi.ads.solution.list;

import java.util.Map;

import de.hska.iwi.ads.dictionary.MapTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DoubleLinkedListTest extends MapTest {

    @Override
    public <K extends Comparable<K>, V> Map<K, V> createMap() {
        return new DoubleLinkedList<>();
    }

    @Test
    void testInsertAndGet() {
        Map<Integer, String> list = createMap();

        list.put(1, "One");
        list.put(2, "Two");

        assertEquals("One", list.get(1));
        assertEquals("Two", list.get(2));
        assertEquals(2, list.size());
    }

    @Test
    void testReplaceValue() {
        Map<Integer, String> list = createMap();

        list.put(1, "One");
        String oldValue = list.put(1, "First");

        assertEquals("One", oldValue);
        assertEquals("First", list.get(1));
        assertEquals(1, list.size());
    }

    @Test
    void testMissingKeyReturnsNull() {
        Map<Integer, String> list = createMap();

        list.put(1, "One");

        assertNull(list.get(2));
    }
}
