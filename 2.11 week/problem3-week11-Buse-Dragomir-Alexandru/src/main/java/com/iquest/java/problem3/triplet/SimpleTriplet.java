package com.iquest.java.problem3.triplet;

public class SimpleTriplet<U, V, T> {

    private U first;
    private V second;
    private T third;

    public SimpleTriplet(U first, V second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public U getFirst() {
        return this.first;
    }

    public V getSecond() {
        return this.second;
    }

    public T getThird() {
        return this.third;
    }
}
