package trådprogrammering;

import javafx.concurrent.Task;

public class Threads extends Task<Integer> {
    private final int value;

    public Threads(int value){
        this.value=value;
    }

    @Override
    protected Integer call(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){

        }
        return value*2;
    }
}
