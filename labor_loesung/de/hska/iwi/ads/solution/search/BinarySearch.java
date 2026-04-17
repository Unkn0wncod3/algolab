package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {

    @Override
    public int search(E[] a, E key, int left, int right) {
        if (a == null) throw new NullPointerException();
        if (key.compareTo(a[left]) < 0) return left - 1;
        if (key.compareTo(a[right]) > 0) return right + 1;

        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = key.compareTo(a[mid]);

            if (cmp == 0) {
                result = mid;
                right = mid - 1;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result != -1 ? result : left;
    }
}
