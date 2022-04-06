package be.aewyn.threads;

import java.time.LocalTime;

public class Clock implements Runnable{
    @Override
    public void run() {
        var doContinue = true;
        while(doContinue){
            System.out.println(LocalTime.now());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
