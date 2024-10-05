package com.iquest.java.problem3.queue;

import com.iquest.java.problem3.car.Car;
import com.iquest.java.problem3.utility.SortingUtility;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    private static final int MAX_QUEUE_SIZE = 12;
    private PriorityQueue<Car> priorityQueue;
    private List<Car> list;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        this.priorityQueue = new PriorityQueue<>(MAX_QUEUE_SIZE);
        this.list = new ArrayList<>();

        this.priorityQueue.insert(new Car("Tesla", 43000));
        this.priorityQueue.insert(new Car("Mazda", 27000));
        this.priorityQueue.insert(new Car("Opel", 19500));
        this.priorityQueue.insert(new Car("Subaru", 39000));
        this.priorityQueue.insert(new Car("Mitsubishi", 31500));
        this.priorityQueue.insert(new Car("Nissan", 27000));
        this.priorityQueue.insert(new Car("Kia", 20000));
        this.priorityQueue.insert(new Car("Jaguar", 90000));
        this.priorityQueue.insert(new Car("Peugeot", 8500));
        this.priorityQueue.insert(new Car("Peugeot", 8500));
        this.priorityQueue.insert(new Car("Corvette", 75000));
        this.priorityQueue.insert(new Car("Dodge", 55000));

        this.list.add(new Car("Tesla", 43000));
        this.list.add(new Car("Mazda", 27000));
        this.list.add(new Car("Opel", 19500));
        this.list.add(new Car("Subaru", 39000));
        this.list.add(new Car("Mitsubishi", 31500));
        this.list.add(new Car("Nissan", 27000));
        this.list.add(new Car("Kia", 20000));
        this.list.add(new Car("Jaguar", 90000));
        this.list.add(new Car("Peugeot", 8500));
        this.list.add(new Car("Peugeot", 8500));
        this.list.add(new Car("Corvette", 75000));
        this.list.add(new Car("Dodge", 55000));
    }

    @Test
    public void testInsertionResult() {
        assertThat(this.priorityQueue.getSize(), is(12));
    }

    @Test
    public void testInsertionFail() {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("Max queue size has been reached; " +
                "cannot add another value");
        this.priorityQueue.insert(new Car("Dacia", 8000));
    }

    @Test
    public void testHead() {
        Collections.sort(list);
        for (int i = 0; i < this.list.size(); i ++) {
            assertThat(this.priorityQueue.head(), is(list.get(list.size() - i - 1)));
            this.priorityQueue.remove();
        }
    }

    @Test
    public void testHeadException() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Cannot get element; the queue is empty");
        this.priorityQueue.clear();
        this.priorityQueue.head();
    }

    @Test
    public void testRemove() {
        Collections.sort(list);
        for (int i = 0; i < this.list.size(); i ++) {
            assertThat(this.priorityQueue.remove(), is(list.get(list.size() - i - 1)));
        }
    }

    @Test
    public void testRemoveException() {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Cannot remove element; the queue is empty");
        for (int i = 0; i < this.list.size(); i ++) {
            this.priorityQueue.remove();
        }
        this.priorityQueue.remove();
    }

    @Test
    public void testClear() {
        this.priorityQueue.clear();
        assertThat(this.priorityQueue.getSize(), is(0));
    }

    @Test
    public void testIsEmptyTrue() {
        this.priorityQueue.clear();
        assertThat(this.priorityQueue.isEmpty(), is(true));
    }

    @Test
    public void testIsEmptyFalse() {
        this.priorityQueue.clear();
        this.priorityQueue.insert(new Car("Dacia", 8000));
        assertThat(this.priorityQueue.isEmpty(), is(false));
    }

    @Test
    public void testMaxCapacity() {
        assertThat(this.priorityQueue.getCapacity(), is(12));
    }

    @Test
    public void testToStringForEmptyQueue() {
        this.priorityQueue.clear();
        assertThat(this.priorityQueue.toString(), is("[]"));
    }

    @Test
    public void testSortingMethodForList() {
        List<Car> anotherList = new ArrayList<>(this.list);
        Collections.sort(this.list);
        SortingUtility sortingUtility = new SortingUtility();
        sortingUtility.sortList(anotherList);
        assertThat(anotherList.equals(this.list), is(true));
    }

    @Test
    public void testCompareToForTwoQueuesSmaller() {
        PriorityQueue<Car> anotherPriorityQueue = new PriorityQueue<>();
        anotherPriorityQueue.insert(new Car("Tesla", 43000));
        anotherPriorityQueue.insert(new Car("Mazda", 27000));
        anotherPriorityQueue.insert(new Car("Opel", 19500));
        anotherPriorityQueue.insert(new Car("Subaru", 39000));
        anotherPriorityQueue.insert(new Car("Mitsubishi", 31500));
        anotherPriorityQueue.insert(new Car("Nissan", 27000));
        anotherPriorityQueue.insert(new Car("Kia", 20000));
        assertThat(anotherPriorityQueue.compareTo(this.priorityQueue), is(-1));
    }

    @Test
    public void testCompareToForTwoQueuesEqual() {
        PriorityQueue<Car> anotherPriorityQueue = new PriorityQueue<>();
        anotherPriorityQueue.insert(new Car("Tesla", 43000));
        anotherPriorityQueue.insert(new Car("Mazda", 27000));
        anotherPriorityQueue.insert(new Car("Opel", 19500));
        anotherPriorityQueue.insert(new Car("Subaru", 39000));
        anotherPriorityQueue.insert(new Car("Mitsubishi", 31500));
        anotherPriorityQueue.insert(new Car("Nissan", 27000));
        anotherPriorityQueue.insert(new Car("Kia", 20000));
        anotherPriorityQueue.insert(new Car("Jaguar", 90000));
        anotherPriorityQueue.insert(new Car("Peugeot", 8500));
        anotherPriorityQueue.insert(new Car("Peugeot", 8500));
        anotherPriorityQueue.insert(new Car("Corvette", 75000));
        anotherPriorityQueue.insert(new Car("Dodge", 55000));
        assertThat(anotherPriorityQueue.compareTo(this.priorityQueue), is(0));
    }

    @Test
    public void testCompareToForTwoQueuesGreater() {
        PriorityQueue<Car> anotherPriorityQueue = new PriorityQueue<>();
        anotherPriorityQueue.insert(new Car("Tesla", 43000));
        anotherPriorityQueue.insert(new Car("Mazda", 27000));
        anotherPriorityQueue.insert(new Car("Opel", 19500));
        anotherPriorityQueue.insert(new Car("Subaru", 39000));
        anotherPriorityQueue.insert(new Car("Mitsubishi", 31500));
        anotherPriorityQueue.insert(new Car("Nissan", 27000));
        anotherPriorityQueue.insert(new Car("Kia", 20000));
        anotherPriorityQueue.insert(new Car("Jaguar", 90000));
        anotherPriorityQueue.insert(new Car("Peugeot", 8500));
        anotherPriorityQueue.insert(new Car("Peugeot", 8500));
        anotherPriorityQueue.insert(new Car("Corvette", 75000));
        anotherPriorityQueue.insert(new Car("Dodge", 55000));
        anotherPriorityQueue.insert(new Car("Dacia", 8000));
        assertThat(anotherPriorityQueue.compareTo(this.priorityQueue), is(1));
    }
}


















