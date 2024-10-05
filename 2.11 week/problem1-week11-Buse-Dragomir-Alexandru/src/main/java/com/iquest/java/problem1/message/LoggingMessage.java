package com.iquest.java.problem1.message;

public class LoggingMessage {

    private static int counter;
    private int messageNumber;

    static {
        counter = 0;
    }

    public LoggingMessage() {
        counter++;
        this.messageNumber = counter;
    }

    public int getMessageNumber() {
        return this.messageNumber;
    }
}
