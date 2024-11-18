package com.javaupskill.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Calculator {

    ReentrantLock lock = new ReentrantLock();

    private int sum;
    private AtomicInteger sum2;


    public Calculator(int sum) {
        this.sum = sum;
        this.sum2 = new AtomicInteger(sum);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public synchronized void increment() {
        sum++;
    }

    public void incrementSum2() {
//        sum2.set(sum2.get() + 1);
        sum2.incrementAndGet();
    }

    public void increment2() {
        // logic that is not conditioned
        synchronized (this) {
            sum++;
        }
    }

    public void increment4() {
        synchronized (this) {
            sum++;
            synchronized (this) {
                // TODO: it works, but why would you do that?
                sum++; // maybe another resource
                // it works to acquire the same lock here from the same thread only
                // different threads won't be able to access it
            }
        }
    }

    public void increment3() {
        lock.lock();
        sum++;
        lock.unlock();
    }

    public AtomicInteger getSum2() {
        return sum2;
    }

    public void setSum2(AtomicInteger sum2) {
        this.sum2 = sum2;
    }
}
