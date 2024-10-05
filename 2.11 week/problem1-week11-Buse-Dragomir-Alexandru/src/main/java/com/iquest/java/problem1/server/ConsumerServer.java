package com.iquest.java.problem1.server;

import com.iquest.java.problem1.queue.MessageQueue;

import java.util.Random;

public class ConsumerServer implements Runnable {

    private MessageQueue messageQueue;
    private boolean runningFlag;

    public ConsumerServer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
        this.runningFlag = true;
    }

    public void setRunningFlag(boolean runningFlag) {
        this.runningFlag = runningFlag;
    }

    @Override
    public void run() {
        while (runningFlag) {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.messageQueue.removeMessage();
        }
    }
}
