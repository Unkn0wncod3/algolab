package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class Mergesort<E extends Comparable<E>> extends AbstractMergesort<E> {

    @Override
    protected void mergesort(E[] a, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        mergesort(a, left, middle);
        mergesort(a, middle + 1, right);
        int l = left, r = middle + 1;

        for (int i = left; i <= right; i++) {
            b[i] = r > right || (l <= middle && a[l].compareTo(a[r]) <= 0) ? a[l++] : a[r++];
        }

        for (int i = left; i <= right; i++) {
            a[i] = b[i];
        }
    }
}
