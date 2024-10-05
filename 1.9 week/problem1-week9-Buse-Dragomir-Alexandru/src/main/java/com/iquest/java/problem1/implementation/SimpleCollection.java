package com.iquest.java.problem1.implementation;

import com.iquest.java.problem1.collection.MyCollection;

import java.util.Arrays;
import java.util.Collection;

public class SimpleCollection<E> implements MyCollection<E> {

    private E[] values;

    public SimpleCollection(E[] values) {
        this.values = values;
    }

    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for (E element: c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null || c.size() == 0) {
            return false;
        } else {
            for (E element: c) {
                this.addElement(element);
            }
            return true;
        }
    }

    @Override
    public E[] getElements() {
        return this.values;
    }

    private boolean contains(E element) {
        for (E value: this.values) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void addElement(E element) {
        this.values = Arrays.copyOf(this.values, this.values.length + 1);
        int newLength = this.values.length;
        this.values[newLength - 1] = element;
    }
}
