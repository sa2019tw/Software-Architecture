package com.company.ThreadTraining;


import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SafePoint {
    @GuardedBy("this") private int x, y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[] { x, y };
    }

    public synchronized int getX() {
        return this.x;
    }

    public synchronized void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
