package com.iquest.java.problem3.queue;

public interface Queue<E> {

    void insert(E e);
    E remove();
    void clear();
    E head();
    boolean isEmpty();
}
