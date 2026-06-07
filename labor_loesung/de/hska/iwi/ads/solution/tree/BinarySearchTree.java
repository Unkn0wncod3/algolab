package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>, V> extends AbstractBinaryTree<K, V> {

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object o) {
        if (o == null) throw new NullPointerException();

        K key = (K) o;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.entry.getKey());

            if (cmp == 0) {
                return current.entry.getValue();
            } else {
                current = cmp < 0 ? current.left : current.right;
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        if (key == null) throw new NullPointerException();

        if (root == null) {
            root = new Node(key, value);
            size++;
            return null;
        }

        Node current = root;
        Node parent = null;
        int cmp = 0;

        while (current != null) {
            parent = current;
            cmp = key.compareTo(current.entry.getKey());

            if (cmp == 0) {
                V oldValue = current.entry.getValue();
                current.entry.setValue(value);
                return oldValue;
            } else {
                current = cmp < 0 ? current.left : current.right;
            }
        }

        if (cmp < 0) {
            parent.left = new Node(key, value);
        } else {
            parent.right = new Node(key, value);
        }

        size++;
        return null;
    }
}
