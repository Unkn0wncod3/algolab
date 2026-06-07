package de.hska.iwi.ads.solution.hashtable;

import java.util.AbstractMap.SimpleEntry;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

    public Hashtable(int capacity) {
        super(capacity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if (o == null) throw new NullPointerException();

        K key = (K) o;
        int index = findIndex(key);

        return index == -1 ? null : hashtable[index].getValue();
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException();

        int oldIndex = findIndex(key);
        if (oldIndex != -1) {
            V oldValue = hashtable[oldIndex].getValue();
            hashtable[oldIndex].setValue(value);
            return oldValue;
        }

        for (int i = 0; i < hashtable.length; i++) {
            int index = hash(key, i);

            if (hashtable[index] == null) {
                hashtable[index] = new SimpleEntry<>(key, value);
                size++;
                return null;
            }
        }

        throw new DictionaryFullException();
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    private int hash(K key, int i) {
        int start = Math.floorMod(key.hashCode(), hashtable.length);
        return (start + i * i) % hashtable.length;
    }

    private int findIndex(K key) {
        for (int i = 0; i < hashtable.length; i++) {
            int index = hash(key, i);

            if (hashtable[index] != null && key.compareTo(hashtable[index].getKey()) == 0) {
                return index;
            }
        }

        return -1;
    }
}
