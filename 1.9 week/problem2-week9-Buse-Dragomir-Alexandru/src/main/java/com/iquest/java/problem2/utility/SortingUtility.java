package com.iquest.java.problem2.utility;

import java.util.Collection;
import java.util.Collections;

public class SortingUtility {

    @SuppressWarnings("unchecked")
    public <T extends Comparable> void bubbleSort(Collection<T> c) {
        int size = c.size();

        T[] array = (T[])(new Comparable[size]);
        c.toArray(array);

        for (int i = 0; i < size - 1; i ++) {
            for (int j = 0; j < size - i - 1; j ++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        c.clear();
        Collections.addAll(c, array);
    }

    public <T> void printCollection(Collection<T> c) {
        for (T element: c) {
            System.out.println(element);
        }
    }
}
