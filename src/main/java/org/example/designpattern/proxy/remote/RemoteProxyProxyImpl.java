package org.example.designpattern.proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


// 通过继承UnicastRemoteObject来成为一个远程服务
public class RemoteProxyProxyImpl extends UnicastRemoteObject implements RemoteProxy {
    // 构造器需要抛出RemoteException
    public RemoteProxyProxyImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() {
        return "Hello from server end";
    }
}
