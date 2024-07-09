package org.practice2;

import java.time.LocalTime;

public class PeriodicTask implements Runnable {
    @Override
    public void run () {
        System.out.println("Task executed at " + LocalTime.now());
    }
}
