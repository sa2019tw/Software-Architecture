package com.company.ThreadTraining;

import java.util.concurrent.BlockingQueue;

public class OuterLock {
    private Object lock = new Object();
    private BlockingQueue<String> blockingQueue;

    public OuterLock(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public String take() {

        synchronized (lock) {
            lock.notifyAll();
        }

        try {
            String s = this.blockingQueue.take();
            System.out.println("Robot fetch" + s);
            return s;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    // crawlJax
    public void put(String s) {
        try {
            System.out.println("CrawlJax push");
            this.blockingQueue.put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            try {
                System.out.println("Waiting");
                lock.wait();
                System.out.println("Leave waiting lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void wakeUpWaitingThread() {
        synchronized (lock) {

            lock.notifyAll();
        }
    }

    public  void blockingCurrentThread() {
        synchronized (lock) {
            try {
                System.out.println("23");
                lock.wait(3000);
                System.out.println("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
