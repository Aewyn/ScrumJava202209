package be.aewyn.threads;

public class GemiddeldeRekenaar implements Runnable{
    private final double[] array;
    private final int start;
    private final int end;
    private double average;

    public GemiddeldeRekenaar(double[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        var total = 0.0D;
        for(var i = start; i < array.length; i++){
            total += array[i];
        }
        average = total / (end - start);
    }

    public double getAverage(){
        return average;
    }
}
