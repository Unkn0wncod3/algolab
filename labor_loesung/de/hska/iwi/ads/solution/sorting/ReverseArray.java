package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

    @Override
    public void reverse(E[] a, int from, int to) {
        while (from < to) {
            E tmp = a[from];
            a[from++] = a[to];
            a[to--] = tmp;
        }
    }
}
