package de.hska.iwi.ads.solution.list;

import java.util.AbstractMap.SimpleEntry;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if (o == null) throw new NullPointerException();

        ListElement element = find((K) o);
        return element == null ? null : element.entry.getValue();
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException();

        ListElement element = find(key);
        if (element != null) {
            V oldValue = element.entry.getValue();
            element.entry.setValue(value);
            return oldValue;
        }

        head = new ListElement(new SimpleEntry<>(key, value), null, head);
        if (head.next != null) {
            head.next.previous = head;
        }
        size++;
        return null;
    }

    private ListElement find(K key) {
        ListElement current = head;

        while (current != null) {
            if (key.compareTo(current.entry.getKey()) == 0) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
}
