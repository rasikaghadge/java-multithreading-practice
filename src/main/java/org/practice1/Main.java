package org.practice1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int[] numbersToCheck = {29, 15, 47, 10, 23, 77, 89};

        for (int number : numbersToCheck) {
            Thread thread = new PrimeCheckerThread(number);
            thread.start();
        }

        for (int number : numbersToCheck) {
            Thread thread = new Thread(new PrimeCheckerRunnable(number));
            thread.start();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int number: numbersToCheck) {
            executorService.submit(new PrimeCheckerExecutor(number));
        }

        executorService.shutdown();
    }
}
