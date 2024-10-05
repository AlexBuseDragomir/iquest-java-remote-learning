package com.iquest.java.problem1.main;

import com.iquest.java.problem1.node.ClusterNode;
import com.iquest.java.problem1.queue.MessageQueue;
import com.iquest.java.problem1.server.ConsumerServer;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    private static final int NUMBER_OF_NODES = 4;

    // both the consumer and the producer are left to run continuously
    // if we want to stop one of them, we can set the runningFlag to false
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue();
        ConsumerServer consumerServer = new ConsumerServer(messageQueue);
        List<Thread> nodeThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_NODES; i ++) {
            Thread producerThread = new Thread(new ClusterNode(messageQueue));
            nodeThreads.add(producerThread);
        }

        for (int i = 0; i < NUMBER_OF_NODES; i ++) {
            nodeThreads.get(i).start();
        }

        new Thread(consumerServer).start();
    }
}
