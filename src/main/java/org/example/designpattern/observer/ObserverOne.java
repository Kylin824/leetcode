package org.example.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverOne implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("o1 update!");
    }
}
