package org.example.designpattern.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteProxy extends Remote {
    String sayHello() throws RemoteException;
}
