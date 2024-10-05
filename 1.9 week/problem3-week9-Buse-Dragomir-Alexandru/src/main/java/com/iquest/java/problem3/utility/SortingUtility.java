package com.iquest.java.problem3.utility;

import com.iquest.java.problem3.queue.PriorityQueue;

import java.util.List;


public class SortingUtility {

    public <E extends Comparable> List<E> sortList(List<E> list) {
        int numberOfValues = list.size();
        PriorityQueue<E> priorityQueue = new PriorityQueue<>(numberOfValues);
        for (E element: list) {
            priorityQueue.insert(element);
        }
        list.clear();
        for (int i = 0; i < numberOfValues; i ++) {
            list.add(0, priorityQueue.remove());
        }
        return list;
    }
}
