package org.practice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PerformanceComparison {
    public static void main(String[] args) throws InterruptedException {
        int numTasks = 100;

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        long fixedThreadPoolStart = System.currentTimeMillis();
        for (int i = 0; i < numTasks; i++) {
            fixedThreadPool.submit(new SimpleTask(i));
        }
        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(1, TimeUnit.MINUTES);
        long fixedThreadPoolEnd = System.currentTimeMillis();
        System.out.println("FixedThreadPool execution time: " + (fixedThreadPoolEnd - fixedThreadPoolStart) + " ms");

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        long cachedThreadPoolStart = System.currentTimeMillis();
        for (int i = 0; i < numTasks; i++) {
            cachedThreadPool.submit(new SimpleTask(i));
        }
        cachedThreadPool.shutdown();
        cachedThreadPool.awaitTermination(1, TimeUnit.MINUTES);
        long cachedThreadPoolEnd = System.currentTimeMillis();
        System.out.println("CachedThreadPool execution time: " + (cachedThreadPoolEnd - cachedThreadPoolStart) + " ms");
    }
}
