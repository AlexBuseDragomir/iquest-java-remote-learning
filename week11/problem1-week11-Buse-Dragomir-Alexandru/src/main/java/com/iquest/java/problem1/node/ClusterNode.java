package com.iquest.java.problem1.node;

import com.iquest.java.problem1.message.LoggingMessage;
import com.iquest.java.problem1.queue.MessageQueue;

import java.util.Random;

public class ClusterNode implements Runnable {

    private MessageQueue messageQueue;
    private boolean runningFlag;

    public ClusterNode(MessageQueue messageQueue) {
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
                Thread.sleep(new Random().nextInt(1000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.messageQueue.addMessage(new LoggingMessage());
        }
    }
}
