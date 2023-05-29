package com.example.demo;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        atomicIntegerArray.accumulateAndGet(2, 6, (left, right) -> left * right);
        int result = atomicIntegerArray.get(2);
        System.out.println(result);
    }
}
