package be.aewyn.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Stack {
    private final AtomicInteger amountOfPancakes = new AtomicInteger();

    public void addPancake(){
        amountOfPancakes.incrementAndGet();
    }

    public int getAmountOfPancakes(){
        return amountOfPancakes.intValue();
    }
}
