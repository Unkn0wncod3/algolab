package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReverseArrayTest {

    @Test
    void testReverseMiddlePart() {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        new ReverseArray<Integer>().reverse(a, 1, 4);
        assertArrayEquals(new Integer[]{1, 5, 4, 3, 2, 6}, a);
    }

    @Test
    void testReverseWholeArray() {
        Integer[] a = {1, 2, 3, 4};
        new ReverseArray<Integer>().reverse(a, 0, 3);
        assertArrayEquals(new Integer[]{4, 3, 2, 1}, a);
    }
}
