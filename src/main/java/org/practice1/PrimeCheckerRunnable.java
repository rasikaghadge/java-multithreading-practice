package org.practice1;

public class PrimeCheckerRunnable implements Runnable {
    private int number;

    public PrimeCheckerRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (isPrime(number)) {
            System.out.println(number + " is a prime number by thread " + Thread.currentThread().getName() + " implementing Runnable");
        } else {
            System.out.println(number + " is not a prime number by thread " + Thread.currentThread().getName() + " implementing Runnable");
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
