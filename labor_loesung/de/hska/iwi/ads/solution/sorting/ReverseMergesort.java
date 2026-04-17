package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

    private final ReverseArray<E> reverse = new ReverseArray<>();

    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        mergesort(a, left, middle);
        mergesort(a, middle + 1, right);

        for (int i = left; i <= right; i++) {
            b[i] = a[i];
        }

        reverse.reverse(b, middle + 1, right);

        int l = left, r = right;

        for (int i = left; i <= right; i++) {
            a[i] = b[l].compareTo(b[r]) <= 0 ? b[l++] : b[r--];
        }
    }
}
