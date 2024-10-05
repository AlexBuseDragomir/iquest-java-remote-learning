package com.iquest.java.problem3.queue;

import com.google.common.collect.TreeMultiset;

import java.util.NoSuchElementException;

public class PriorityQueue <E extends Comparable> implements Comparable<PriorityQueue<E>>, Queue<E> {

    private static final int MAX_QUEUE_SIZE = 10000;
    private TreeMultiset<E> values;
    private int maxSize;

    public PriorityQueue() {
        this.values = TreeMultiset.create();
        this.maxSize = MAX_QUEUE_SIZE;
    }

    public PriorityQueue(int maxSize) {
        this.values = TreeMultiset.create();
        this.maxSize = maxSize;
    }

    public int getSize() {
        return this.values.size();
    }

    public int getCapacity() {
        return this.maxSize;
    }

    @Override
    public void insert(E element) {
        if (this.values.size() < this.maxSize) {
            this.values.add(element);
        } else {
            throw new IndexOutOfBoundsException("Max queue size has been reached; " +
                    "cannot add another value");
        }
    }

    @Override
    public E remove() {
        if (this.values.size() == 0) {
            throw new NoSuchElementException("Cannot remove element; the queue is empty");
        } else {
            E maxElement = this.values.lastEntry().getElement();
            this.values.remove(maxElement);
            return maxElement;
        }
    }

    @Override
    public E head() {
        if (this.values.size() == 0) {
            throw new NoSuchElementException("Cannot get element; the queue is empty");
        } else {
            return this.values.lastEntry().getElement();
        }
    }

    @Override
    public void clear() {
        this.values.clear();
    }

    @Override
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override
    public int compareTo(PriorityQueue<E> priorityQueue) {
        return Integer.compare(this.getSize(), priorityQueue.getSize());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        if (this.values.size() > 0) {
            for (E element: this.values) {
                stringBuilder.append(element);
                stringBuilder.append(", ");
            }
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
