package org.example.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverTwo implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("o2 update!");
    }
}
