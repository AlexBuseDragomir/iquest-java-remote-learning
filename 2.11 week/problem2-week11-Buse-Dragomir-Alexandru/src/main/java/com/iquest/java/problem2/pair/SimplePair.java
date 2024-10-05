package com.iquest.java.problem2.pair;

public class SimplePair<U, V> {

    private U first;
    private V second;

    public SimplePair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }
}
