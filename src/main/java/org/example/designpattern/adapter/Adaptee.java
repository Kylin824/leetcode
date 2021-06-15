package org.example.designpattern.adapter;

public class Adaptee implements Target {
    @Override
    public void request() {
        System.out.println("request by adaptee");
    }
}
