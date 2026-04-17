package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;

class BinarySearchTest extends SearchTest {

    @Override
    public <E extends Comparable<E>> Search<E> createSearch() {
        return new BinarySearch<>();
    }

    @Test
    void testSearchReturnsLeftmostDuplicateInsideRange() {
        Integer[] a = {0, 1, 2, 2, 2, 3, 4};
        Search<Integer> search = createSearch();

        assertEquals(2, search.search(a, 2, 2, 4));
    }

    @Test
    void testSearchReturnsInsertionPointInsideRange() {
        Integer[] a = {0, 2, 4, 6, 8, 10};
        Search<Integer> search = createSearch();

        assertEquals(3, search.search(a, 5, 1, 4));
    }
}
