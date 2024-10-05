package com.iquest.java.problem1.collection;

import java.util.Collection;

public interface MyCollection<E> {

    boolean containsAll(Collection<? extends E> c);
    boolean addAll(Collection<? extends E> c);
    // added in order to ease the testing in main;
    // not used in unit testing
    E[] getElements();
}
