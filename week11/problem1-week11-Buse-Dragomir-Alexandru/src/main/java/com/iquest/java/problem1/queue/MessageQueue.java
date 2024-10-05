package com.iquest.java.problem1.queue;

import com.iquest.java.problem1.message.LoggingMessage;

import java.util.Deque;
import java.util.LinkedList;

public class MessageQueue {

    private static final int MAX_NUMBER_OF_MESSAGES = 10;
    private Deque<LoggingMessage> queue;

    public MessageQueue() {
        this.queue = new LinkedList<>();
    }

    public synchronized void addMessage(LoggingMessage message) {
        while (this.isQueueFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.addLast(message);
        System.out.println("The message " + message.getMessageNumber() +
                " has been ADDED");
        notifyAll();
    }

    public synchronized void removeMessage() {
        while (this.isQueueEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LoggingMessage extractedMessage = this.queue.removeFirst();
        System.out.println("The message " + extractedMessage.getMessageNumber() +
                " has been REMOVED");
        notifyAll();
    }

    private boolean isQueueEmpty() {
        return this.queue.isEmpty();
    }

    private boolean isQueueFull() {
        return this.queue.size() == MAX_NUMBER_OF_MESSAGES;
    }
}
