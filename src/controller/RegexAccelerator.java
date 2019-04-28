package controller;

import java.util.Observable;
import java.util.Observer;

public class RegexAccelerator implements Observer {
    @Override
    public void update(Observable o, Object arg){
        if (o instanceof FilterInterpreter){
            System.out.println("Accelerate regex run process for REGEX: " + arg);
        }
    }
}
