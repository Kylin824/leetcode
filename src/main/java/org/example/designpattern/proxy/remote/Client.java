package org.example.designpattern.proxy.remote;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    RemoteProxy serviceRemote;

    public Client(RemoteProxy serviceRemote) {
        this.serviceRemote = serviceRemote;
    }

    public void report() {
        try {
            serviceRemote.sayHello();
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // 1、客户端注册Registry并查找相应对象
            Registry registry = LocateRegistry.getRegistry(1099);
            // 注意：客户端不涉及接口的具体实现类，具体实现类在服务器端实现并被客户端远程调用
            RemoteProxy remoteProxy = (RemoteProxy) registry.lookup("HelloRemoteService");

            String res = remoteProxy.sayHello();

            System.out.println(res);

            System.out.println("Client RMI 调用结束");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }
}
