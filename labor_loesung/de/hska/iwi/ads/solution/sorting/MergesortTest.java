package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergesortTest {

    @Test
    void testSortIntegers() {
        Integer[] a = {7, 3, 9, 1, 5, 2};
        new Mergesort<Integer>().sort(a);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 7, 9}, a);
    }

    @Test
    void testSortKeepsDuplicatesStable() {
        Item[] a = {
                new Item(2, "a"),
                new Item(1, "b"),
                new Item(2, "c"),
                new Item(1, "d")
        };

        new Mergesort<Item>().sort(a);

        assertArrayEquals(new Item[]{
                new Item(1, "b"),
                new Item(1, "d"),
                new Item(2, "a"),
                new Item(2, "c")
        }, a);
    }

    private record Item(int value, String id) implements Comparable<Item> {
        @Override
        public int compareTo(Item other) {
            return Integer.compare(value, other.value);
        }
    }
}
