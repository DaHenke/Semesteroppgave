package trådprogrammering;

import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.ControllerLogIn;

public class Threads {

    public static void tr1() {
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("da");
    }
    public static void tr2(Label lbl){
        lbl.setText("Login successful");
        System.out.println("kjør");
    }


}
