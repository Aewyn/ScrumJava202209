package be.aewyn.threads;

public class Chef implements Runnable{
    private final Stack stack;

    public Chef(Stack stack){
        this.stack = stack;
    }

    @Override
    public void run() {
        for (var i = 0; i != 100; i++){
            stack.addPancake();
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
