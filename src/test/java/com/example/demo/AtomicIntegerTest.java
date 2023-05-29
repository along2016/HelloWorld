package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static AtomicInteger counter = new AtomicInteger();

    public static void increment(){
//        counter.getAndIncrement();
        counter.getAndAccumulate(3, (left, right) -> left + right);
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(counter.get());
    }
}
