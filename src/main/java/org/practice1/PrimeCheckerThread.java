package org.practice1;

public class PrimeCheckerThread extends Thread {
    private int number;

    public PrimeCheckerThread(int number) {
        this.number = number;
    }

    public void run () {
        if (isPrime(number)) {
            System.out.println(number + " is a prime mumber by thread " + Thread.currentThread().getName() + " extending Thread");
        } else {
            System.out.println(number + " is not a prime number by thread " + Thread.currentThread().getName() + " extending Thread");
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
