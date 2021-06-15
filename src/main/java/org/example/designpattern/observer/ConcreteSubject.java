package org.example.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

// 自定义具体被观察的对象
public class ConcreteSubject extends Observable {

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ObserverOne o1 = new ObserverOne();
        ObserverTwo o2 = new ObserverTwo();
        concreteSubject.addObserver(o1); // 添加观察者1
        concreteSubject.addObserver(o2); // 添加观察者2
        concreteSubject.setChanged(); // 被观察的对象发生变化
        concreteSubject.notifyObservers(); // 通知所有观察者，被通知的观察者会执行update()方法
    }
}
